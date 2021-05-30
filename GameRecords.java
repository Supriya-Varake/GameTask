package com.gamedetails;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.sql.Connection;

public class GameRecords {
		private List <String []> Headers = new ArrayList<>();
		private List <String []> Entries = new ArrayList<>();

		public List<String[]> getHeaders() {
			return Headers;
		}

		public List<String[]> getEntries() {
			return Entries;
		}

	  public static List<String[]> readFileInfo()throws Exception {

			  FileReader FR= new FileReader("c:\\Supriya Software Class\\Task1Program\\gamefilesmall.csv");

			  BufferedReader BR = new BufferedReader(FR);

			  List <String []> valueslist = new ArrayList<>();
			    String line;
		    	 
			    while ((line= BR.readLine())!= null) {   //read next line
					String[] values =line.split("\\|");
				    valueslist.add(values);
	                }	 

			    // while(itr.hasNext()) {
			    // 	String[]dummy array =itr.next();	    	
		  	//System.out.println(Arrays.toString(dummy array));
                      
			           BR.close();
			           return valueslist;
		}
	
		  private void SeperateArrays(List<String[]>list) { 		
		    Iterator<String[]> itr = list.iterator();
			while(itr.hasNext()) {
				String [] seperaterows =  itr.next();
				if(Integer.parseInt( seperaterows[0].trim()) == 0)
				{
					Headers.add( seperaterows);
				}
				else {
					Entries.add( seperaterows);
					 }
			}
	}

		   public static void main(String[] args)throws Exception {
		   List<String []> result= GameRecords.readFileInfo();
	          GameRecords gr= new GameRecords();
		         gr.SeperateArrays(result);
	     Iterator<String[]>itr=gr.Entries.iterator();
	    while(itr.hasNext()) {
	    	
	     }
		         List<String []> h=gr.Headers;
		         List<String []> e= gr.Entries;

		         Connection con= DatabasePerform.getDataBaseConnetion();
		         DatabasePerform.InsertdatatoDB(h,e,con);

	           }

	}







