package com.gamedetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class DatabasePerform {
	

		static String url = "jdbc:mysql://localhost:3306/MyData";
		static String userName = "root";
		static String password = "sup@123";
		static String driverClassPath = "com.mysql.jdbc.Driver";

		public static Connection getDataBaseConnetion() {
			Connection CN = null;
			try {
				Class.forName(driverClassPath);
				CN = DriverManager.getConnection(url, userName, password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return CN;
		}
		public static void InsertdatatoDB(List<String[]> header, List<String[]>entry, Connection con)throws Exception{		
			String headerindex;
			String[]entrylist;
			String values="";
			String coloumns="";
			String[]coloumnlist;
			String statement;
             for(int i=0; i<entry.size(); i++) {
			    values="";
				coloumns="";			
				entrylist=entry.get(i);
				headerindex=entrylist[0];
								System.out.println(headerindex);
				
				for(int r=1;r<entrylist.length;r++) {
					
					System.out.println(entrylist[r]);
					
					if (r< entrylist.length-1) 
					{
						values=values.concat("\'").concat(entrylist[r].trim()).concat("\'").concat(" , ");
					}
					else
					{
						values=values.concat("\'").concat(entrylist[r].trim()).concat("\'");
					}
				}
				
				coloumnlist=header.get(Integer.parseInt(headerindex.trim())-1);
               //headers
				for(int s=1;s<coloumnlist.length;s++) {
					if (s<coloumnlist.length -1 ) 
					{
						coloumns= coloumns.concat(coloumnlist[s].trim().replace(" ", "")).concat(",");
					}
					else 
					{
						coloumns= coloumns.concat(coloumnlist[s].trim().replace(" ", ""));
					}
				}
				//columns
				statement="insert into spindemo(RecordType,".concat(coloumns).concat(")values(").concat(headerindex).concat(" , ").concat(values).concat(")");

				System.out.println(statement);

				Statement stmt = con.createStatement();
				int affectedrow = stmt.executeUpdate(statement);
				System.out.println("row affected : " + affectedrow);

			}
	  }

	}


