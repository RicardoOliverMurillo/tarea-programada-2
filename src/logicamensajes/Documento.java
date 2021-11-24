package logicamensajes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import logicanegocios.Cita;

public class Documento{
	
	public void csvGenerator(List<String[]> csvData, String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Betsy\\Desktop\\"+fileName+".csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void dataCitasCSV(List<Cita> dataCitas) {
		List<String[]> stringData = new ArrayList<String[]>();
		String[] header = {"Cedula", "Especialidad", "Estado", "Fecha", "Observación"};
		stringData.add(header);
		
		for(int i = 0; i<dataCitas.size(); i++) {
			String[] row = {
					Integer.toString(dataCitas.get(i).getCedula()), 
					dataCitas.get(i).getEspecialidad(), 
					dataCitas.get(i).getEstado(), 
					dataCitas.get(i).getFecha(),
					dataCitas.get(i).getObservacion()
					};
			stringData.add(row);
		}
		
		csvGenerator(stringData, "ReporteCitas");
	}
	
	public List<String[]> diagnostico(List<List<String>> data) {
		List<String[]> stringData = new ArrayList<String[]>();
		String[] header = {"ID Diagnostico", "Nombre", "Nivel", "Observaciones","Cedula Paciente", "Fecha"};
		stringData.add(header);
		
		for(int i = 0; i<data.size(); i++) {
			String[] row = {
					data.get(i).get(0), 
					data.get(i).get(1), 
					data.get(i).get(2), 
					data.get(i).get(3),
					data.get(i).get(4),
					data.get(i).get(5)
					};
			stringData.add(row);
		}
		
		return stringData;
	}
	
	public List<String[]> dataCSV(List<Cita> dataCitas) {
		List<String[]> stringData = new ArrayList<String[]>();
		for(int i = 0; i<dataCitas.size(); i++) {
			String[] row = {
					Integer.toString(dataCitas.get(i).getCedula()), 
					dataCitas.get(i).getEspecialidad(), 
					dataCitas.get(i).getEstado(), 
					dataCitas.get(i).getFecha(),
					dataCitas.get(i).getObservacion()
					};
			stringData.add(row);
		}
		
		return stringData;
	}
	public void htmlFormat(List<Cita> data, ArrayList<String> headers) {
		String rows = rowsContent (data);
		String tableHeaders = tableHeaders(headers);
		
		String htmlContent = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <style>\r\n"
				+ "    table {\r\n"
				+ "      font-family: arial, sans-serif;\r\n"
				+ "      border-collapse: collapse;\r\n"
				+ "      width: 100%;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    td, th {\r\n"
				+ "      border: 1px solid #dddddd;\r\n"
				+ "      text-align: left;\r\n"
				+ "      padding: 8px;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    tr:nth-child(even) {\r\n"
				+ "      background-color: #dddddd;\r\n"
				+ "    }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <table>\r\n"
				+
				tableHeaders
				+
				rows
				+ "    </table>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		File f = new File("C:\\Users\\Betsy\\Desktop\\ReporteCitas.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(htmlContent);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String tableHeaders(ArrayList<String> headers) {
		String tableHeaders = "<tr>";
		
		for (int i = 0; i<headers.size(); i++) {
			tableHeaders += "<th>" + headers.get(i) + "</th>";;
		}
		
		tableHeaders += "</tr>";
		
		return tableHeaders;
	}
	
	public String rowsContent (List<Cita> data) {
		
		String rows = "";
		
		for (int i = 0; i<data.size(); i++) {
			rows += "<tr>"
					+ "<td>"+Integer.toString(data.get(i).getCedula())+"</td>"
					+ "<td>"+data.get(i).getEspecialidad()+"</td>"
					+ "<td>"+data.get(i).getEstado()+"</td>"
					+ "<td>"+data.get(i).getFecha()+"</td>"
					+ "<td>"+data.get(i).getObservacion()+"</td>"
					+ "</tr>";
		}
		
		return rows;
	}
	
	private void addTableHeader(PdfPTable table) {
	    Stream.of("Cedula", "Especialidad", "Estado", "Fecha","Observación")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private void addRows(PdfPTable table, List<Cita> data) {
		for (int i = 0; i<data.size(); i++) {			
			table.addCell(Integer.toString(data.get(i).getCedula()));
			table.addCell(data.get(i).getEspecialidad());
			table.addCell(data.get(i).getEstado());
			table.addCell(data.get(i).getFecha());
			table.addCell(data.get(i).getObservacion());
		}
	}
	
	public void generatePDF(List<Cita> data) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Betsy\\Desktop\\report.pdf"));
	
			document.open();
	
			PdfPTable table = new PdfPTable(5);
			addTableHeader(table);
			addRows(table, data);
	
			document.add(table);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void diagnosticoCSV(List<List<String>> data) {
	List<String[]> stringData = new ArrayList<String[]>();
	String[] header = {"ID Diagnostico", "Nombre", "Nivel", "Observaciones","Cedula Paciente", "Fecha"};
	stringData.add(header);
	
	for(int i = 0; i<data.size(); i++) {
		String[] row = {
				data.get(i).get(0), 
				data.get(i).get(1), 
				data.get(i).get(2), 
				data.get(i).get(3),
				data.get(i).get(4),
				data.get(i).get(5)
				};
		stringData.add(row);
	}
	
	csvGenerator(stringData, "ReporteCitas");
}
	
	
}
