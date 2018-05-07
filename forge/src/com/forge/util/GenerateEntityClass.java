package com.forge.util;




	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.io.Serializable;
	import java.sql.SQLException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.List;




	public class GenerateEntityClass extends JdbcUtil {
		
		private String packageOutPath = "com.forge.bean";  //ָ��ʵ���������ɰ���·��
		private List<Object> tables = new ArrayList();  //�洢���б������
		private String tableName = "";   //�������
		List colNames = null;   //�洢���Ե�����
		List colTypes = null;   //�洢���Ե�����
		private String authorName = " ����";  //��������
		private String changeTableNameStr = "";//�շ�ת���������  
		private boolean f_util = false;  //�Ƿ���java.util��
		private boolean f_sql = false;   //�Ƿ���java.sql��
		private boolean f_decimal = false;//�Ƿ���Ҫ����java.math.BigDecimal 
		
		//�����ݿ��л�ȡ���б�
		public void showTables(){
			String sql = "show tables";
			try {
				rs = getmyExecuteQuery(sql);
				while (rs.next()){
					int i =1;
					tables.add(rs.getObject(i));  //�����������ӵ�������
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeConnection();
			}
			
			/*for(Object a :tables){
				System.out.println(a.toString());
			}*/
		}
		
		//���ɶ��ʵ����
		public void generaTableEntities(){
			showTables();
			for(int i=0;i<tables.size();i++){
				tableName = tables.get(i).toString();
				genTableEntity(tableName); //����ʵ����
			}
		}
		
		//��ȡ���е���������
		public void descTable(String tableName){
			 colNames = new ArrayList();   //�洢���Ե�����
			 colTypes = new ArrayList();   //�洢���Ե�����
			String sql = "desc "+ tableName;
			try {
				rs = getmyExecuteQuery(sql);
				while(rs.next()){
					
					String filed = rs.getString("Field");
					String type = rs.getString("Type");

					/*if(type.contains("(")){
						String[] split = type.split("(");
						for(String a :split){
							System.out.println(a+" ");
						}
						//type=split[0];
					}*/
					//System.out.println(filed);
					//System.out.println(type);
					colNames.add(filed);
					colTypes.add(type);
					if(type.contains("timestamp")||type.contains("datetime")){
						f_util = true;
					}
					if(type.contains("image")||type.contains("text")){
						f_sql = true;
					}
					if(type.contains("decimal")){
						f_decimal = true;
					}
				}
			//	parse(colNames,colTypes);   //����ʵ��������Ժͷ���
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeConnection();
			}
		}

		/**
		 * ����ʵ�������Ҫ����
		 * @param colName  ��������
		 * @param colType  ��������
		 * 
		 * \r return��������ص��еĿ�ͷ
		 * \n newline������
		 * 
		 */
		private String parse(List colName, List colType) {
			StringBuffer sb = new StringBuffer();
			//������ת��Ϊ�շ���ʽ
			String []tableNameStr = tableName.toLowerCase().split("_");
			changeTableNameStr = "";
			/*for(String table: tableNameStr){
				changeTableNameStr +="_"+ initCap(table);
			}*/
			for(int i=0;i<tableNameStr.length;i++){
				if(i==0){
					changeTableNameStr+=initCap(tableNameStr[i]);
					}else{
					changeTableNameStr+="_"+initCap(tableNameStr[i]);
				}
			}
				
			sb.append("package " +this.packageOutPath+";\r\n");
			sb.append("\r\n");
			
			//�ж��Ƿ��빤�߰�
			sb.append("import java.io.Serializable;");
			sb.append("\r\n");
			if(f_util){
				sb.append("import java.sql.Date;\r\n");
			}
			if(f_sql){
				sb.append("import java.sql.*;\r\n");
			}
			if(f_decimal){
				sb.append("import java.math.BigDecimal;\r\n");
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			sb.append("\r\n");
			//ע�Ͳ���
			sb.append("/**\r\n");
			sb.append("*Created by"+this.authorName+"on"+df.format(new java.util.Date())+"\r\n");
			sb.append("*@Descrption"+tableName+"ʵ����\r\n");
			sb.append("*/ \r\n");
			
			//ʵ�岿��
			sb.append("\r\n\r\npublic class "+changeTableNameStr+"  implements Serializable"+"{\r\n");
			processAllAttrs(sb);  //�������е�����
			processConstructor(sb);   //���ܣ��������췽��
			processAllMethod(sb);  //����get set����
			sb.append("}\r\n");
			return sb.toString();
			
		}
		
		/**
		 * ���ܣ��������췽��
		 * @param sb
		 */
		private void processConstructor(StringBuffer sb) {
			sb.append("\tpublic "+changeTableNameStr+"(){}");
			sb.append("\r\n");
			sb.append("\tpublic "+changeTableNameStr+"(");
			for(int i=0;i<colNames.size();i++){
				if(i==colNames.size()-1){
					sb.append(sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i));
				}else{
					sb.append(sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i)+",");
				}
			}
			sb.append("){\r\n");
			sb.append("\tsuper();");
			sb.append("\r\n");
			for(int i=0;i<colNames.size();i++){
				sb.append("\tthis. "+colNames.get(i)+"="+colNames.get(i)+";\r\n");
			}
			sb.append("}\r\n");
		}

		/**
		 * ���ܣ��������з���
		 * @param sb
		 */
		private void processAllMethod(StringBuffer sb) {
			for (int i = 0; i < colNames.size(); i++) {  
	            sb.append("\tpublic void set" + initCap(colNames.get(i).toString()) + "(" + sqlType2JavaType(colTypes.get(i).toString()) + " " +  
	            		colNames.get(i) + "){\r\n");  
	            sb.append("\tthis." + colNames.get(i) + "=" + colNames.get(i) + ";\r\n");  
	            sb.append("\t}\r\n");  
	            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i).toString()) + " get" + initCap(colNames.get(i).toString()) + "(){\r\n");  
	            sb.append("\t\treturn " + colNames.get(i) + ";\r\n");  
	            sb.append("\t}\r\n");  
	        }  
		}
		
		/**
		 * ���ܣ�������������
		 * @param sb
		 */
		private void processAllAttrs(StringBuffer sb) {
			for(int i=0;i<colNames.size();i++){
				sb.append("\tprivate "+sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i)+";\r\n");
			}
		}
		
		/**
		 * ���ܣ�����е���������
		 * @param sqlType
		 * @return
		 */
		private String sqlType2JavaType(String sqlType) {
			 if(sqlType.contains("bit")){  
		            return "boolean";  
		        }else if(sqlType.contains("tinyint")){  
		            return "byte";  
		        }else if(sqlType.contains("smallint")){  
		            return "short";  
		        }else if(sqlType.contains("int")){  
		            return "int";  
		        }else if(sqlType.contains("bigint")){  
		            return "long";  
		        }else if(sqlType.contains("float")){  
		            return "float";  
		        }else if(sqlType.contains("numeric")  
		                || sqlType.contains("real") || sqlType.contains("money")  
		                || sqlType.contains("smallmoney")||sqlType.contains("double")){  
		            return "double";  
		        }else if(sqlType.contains("varchar") || sqlType.contains("char")  
		                || sqlType.contains("nvarchar") || sqlType.contains("nchar")  
		                || sqlType.contains("text") || sqlType.contains("json")){  
		            return "String";  
		        }else if(sqlType.contains("datetime")||sqlType.contains("timestamp")){  
		            return "Date";  
		        }else if(sqlType.contains("image")){  
		            return "Blod";  
		        }else if(sqlType.contains("decimal")){  
		            return "BigDecimal";  
		        }  
		  
			return null;
		}
		
		/**
		 * ���ܣ��������ַ���������ĸ�ĳɴ�д
		 * @param table
		 * @return
		 */
		private String initCap(String str) {
			char []ch = str.toCharArray();
			if(ch[0]>='a' && ch[0]<='z'){
				ch[0]=(char)(ch[0]-32);
			}
			return new String(ch);
		}
		
		//��ʵ����д�����
		public void genTableEntity (String tableName){
			descTable(tableName);
			String content = parse(colNames,colTypes);
			File directory = new File("");
			//System.out.println("����·����"+directory.getAbsolutePath());  
	        //System.out.println("���·����"+directory.getCanonicalPath());  
			String path = this.getClass().getResource("").getPath();
			
//	        System.out.println(path);  
//	        System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );  
//	        String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initCap(tablename) + ".java";  
//	        System.out.println( "\\src\\\\main\\java\\"+this.packageOutPath.replace(".", "\\")+"\\"+initCap(tableName) + ".java");  
			  
			String outputPath = directory.getAbsolutePath()+"\\src\\\\"+this.packageOutPath.replace(".", "\\")+"\\"+changeTableNameStr  + ".java";
			//System.out.println(directory.getAbsolutePath());
			File file = new File(outputPath);
			try {
				if(!file.exists()){
					file = new File(directory.getAbsolutePath()+ "\\src\\\\"+this.packageOutPath.replace(".", "\\"),initCap(changeTableNameStr)+ ".java");
				    file.createNewFile();				
				}
				FileWriter fw = new FileWriter(outputPath);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	public static void main(String[] args) {
		GenerateEntityClass a= new GenerateEntityClass();
		a.generaTableEntities();
	}	
		
		
		
		
		
		
	}


