package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) {

		String ProjPath=System.getProperty("user.dir");
		System.out.println(ProjPath);
		String FilePath=ProjPath+"/TestData/DataFile.xlsx";
		System.out.println(FilePath);

		//Specify the path of the file and pass through some stream
		File f = new File(FilePath);  
		try {
			FileInputStream fis = new FileInputStream(f);
			Workbook workbook = null ;

			if(FilePath.contains(".xlsx"))
			{				
				try {
					workbook = new XSSFWorkbook(fis);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(FilePath.contains(".xls"))
			{
				try {
					workbook = new HSSFWorkbook(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}	
			//System.out.println(workbook.getNumberOfSheets());  //get all number of rows
			int n=workbook.getNumberOfSheets();  
			for(int i=0;i<n;i++)  //print sheet name 
			{
				System.out.println(workbook.getSheetName(i));

				if(workbook.getSheetName(i).equals("Sheet1"))
				{
					//System.out.println(workbook.getSheetAt(i).getPhysicalNumberOfRows()); //5
					int rows=workbook.getSheetAt(i).getPhysicalNumberOfRows();//getting no of rows which have data
					Sheet sheet = workbook.getSheetAt(i);//creating object of sheet	
					Row HeaderrowObj=sheet.getRow(0);

					int executionflagcolNumber = 0;
					for(int w=0;w<HeaderrowObj.getPhysicalNumberOfCells();w++){
						if(HeaderrowObj.getCell(w).toString().equalsIgnoreCase("ExecutionFlag")){
							executionflagcolNumber=w;
							break;
						}
					}
					Map<Object,HashMap<Object,Object>> newmap= new HashMap<Object,HashMap<Object,Object>>();
					for(int j=1;j<rows;j++)
					{
						Row row=sheet.getRow(j);
						int cells= row.getPhysicalNumberOfCells();
						//System.out.println(cells);
						HashMap<Object, Object> map=new HashMap<Object,Object>();


						for(int k=0;k<cells;k++)
						{
							if(row.getCell(executionflagcolNumber).toString().equalsIgnoreCase("Yes")){
								Cell cell=row.getCell(k);	//object of cell by using object of row									
								//System.out.println(HeaderrowObj.getCell(k).toString()+" = "+cell.toString()); //print value of all cells
								String Header = HeaderrowObj.getCell(k).toString();
								String Value = cell.toString();
								//	Map<Object,Object> map=new HashMap<Object,Object>();
								map.put(Header, Value);													
								//System.out.println(Header +" "+ map.get(Header));	
								newmap.put(j, map);
							}
						}

					}
					System.out.println(newmap);
				}
			} 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}


