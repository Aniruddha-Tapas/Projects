package filefinder;

import java.io.*;
import java.util.*;

class FileFinder{

static String ConvertFilesToString(File St)
{
	String Obj=St.getPath();
	return Obj;
}

public static void main (String[]args){
	int i;
	int Flag=1;
	File Obj=new File(".");
	String FileName="user.dat";
	File []Arry=Obj.listRoots();

	Stack stack=new Stack();

	System.out.println("Please Wait...");

	for (int a=0;a<Arry.length&&Flag==1;a++)
	{


		if (Arry[a].exists())
		{


	String Str=Arry[a].getPath();
	File O=new File(Str);
	File [] Arr= O.listFiles();

	for (i=0;i<Arr.length;i++)
	if (Arr[i].isDirectory()&&Arr[i].canRead())
		stack.push(Arr[i]);
	else
	{
		if (Arr[i].isFile()) {
		String StringObj=Arr[i].getName();
	if(FileName.equalsIgnoreCase(StringObj)&&Arr[i].canRead()){
			   Flag=0;
			   System.out.println("File Found");
			   System.out.println(Arr[i].getPath());
			   }//if
		   }//outer if

	}


	while (!stack.empty()&&Flag==1)
		{
try{
	O=new File(ConvertFilesToString((File)stack.pop()));
	Arr=O.listFiles();

for (i=0;i<Arr.length;i++)
{
if (Arr[i].isDirectory()&&Arr[i].canRead())
	stack.push(Arr[i]);
if (Arr[i].isFile()&&Arr[i].canRead()) {
	String StringObj=Arr[i].getName();
	if(FileName.equalsIgnoreCase(StringObj)){
	   Flag=0;
	   System.out.println("File Found");
		   System.out.println(Arr[i].getPath());
	   }//if
   }//outer if

			}//for Loop
}//try
catch (Exception e){
}


		}//while Loop
	}//outer If
	}//Outer For Loop

if (Flag==1)
System.out.println("File "+FileName+" Does not Exists");
}
}
