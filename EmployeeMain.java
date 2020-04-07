/*
Jorge Lopez
Demo app
*/
import objects.Employee;
import objects.Record;
import objects.Address;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Vector;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.io.FileNotFoundException;

import java.awt.Container;
import javax.swing.JFrame;  
import javax.swing.JTable; 
import javax.swing.JScrollPane;  
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;


public class EmployeeMain {
	
	public static void main(String[] args){

		ArrayList<Employee> empList = loadData();

		EmployeeMain empMain = new EmployeeMain(empList);
	}

		private static ArrayList<Employee> loadData(){
			ArrayList<Employee> empList = new ArrayList<>();
			
			try (FileReader reader = new FileReader("data/finalEmployeeData.txt");
			BufferedReader br = new BufferedReader(reader)) {

			String line;
			String[] tokens = new String[10];

			while ((line = br.readLine()) != null) {
				tokens = line.split(",");

				for(int i=0; i<tokens.length; i++){
					tokens[i] = tokens[i].trim();
				}

				Employee tempEmp = new Employee();
				tempEmp.setFirstName(tokens[0]);
				tempEmp.setLastName(tokens[1]);
				tempEmp.setPhoneNumber(tokens[2]);
				
				Address tempAdd = new Address();
				tempAdd.setStreet(tokens[3]);
				tempAdd.setCity(tokens[4]);
				tempAdd.setState(tokens[5]);
				tempAdd.setZipCode(tokens[6]);
				
				tempEmp.setAddress(tempAdd);
			
				Record tempRec = new Record();
				tempRec.setLicenseStatus(tokens[7]);
				tempRec.setAccidents(Integer.parseInt(tokens[8]));
				tempRec.setViolations(Integer.parseInt(tokens[9]));
				
				tempEmp.setRecord(tempRec);
			
				empList.add(tempEmp);
			}
			System.out.println("empList size: "+empList.size());
	     } 
	     catch(FileNotFoundException e){
	     	e.printStackTrace();
	     }
	     catch (IOException e) {
	        e.printStackTrace();
	     }
	     catch(Exception e){
	     	e.printStackTrace();
	     }

	     	return empList;
		}


		public EmployeeMain(ArrayList<Employee> empList){

			//GUI
			JFrame frame = new JFrame("Employee Viewer");
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    	DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("First Name");
		        model.addColumn("Last Name");
		        model.addColumn("Phone Number");
		        model.addColumn("Address");
		        model.addColumn("Record");

	        for (int i = 0; i < empList.size(); i++){
	            Vector<String> firstName = new Vector<>(Arrays.asList(empList.get(i).getFirstName()));
	            Vector<String> lastName = new Vector<>(Arrays.asList(empList.get(i).getLastName()));
	            Vector<String> phoneNumber = new Vector<>(Arrays.asList(empList.get(i).getPhoneNumber()));
	            Vector<Address> address = new Vector<>(Arrays.asList(empList.get(i).getAddress()));
	            Vector<Record> record = new Vector<>(Arrays.asList(empList.get(i).getRecord()));

	            Vector<Object> row = new Vector<Object>();
	            row.addElement(firstName.get(0));
	            row.addElement(lastName.get(0));
	            row.addElement(phoneNumber.get(0));
	            row.addElement(address.get(0));
	            row.addElement(record.get(0));

	            model.addRow(row);
	        }

        	JTable jt = new JTable(model);    
	    	jt.setBounds(30,40,200,300); 
	    	jt.setAutoCreateRowSorter(true);
	    	jt.setDefaultEditor(Object.class, null);  
	    	jt.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
	    	JScrollPane sp=new JScrollPane(jt);    
	    	frame.add(sp);    
	    	frame.setSize(450,600);    
	    	frame.setVisible(true); 
			//GUI end

			//jtable listener
				ListSelectionModel rowSM = jt.getSelectionModel();

	    		rowSM.addListSelectionListener(new ListSelectionListener(){
			        public void valueChanged(ListSelectionEvent event) {
			        	if (event.getValueIsAdjusting()) return;
			            
			            int selectedRow = jt.getSelectedRow();
			            System.out.println("row selected: "+selectedRow);
			           	System.out.println(model.getDataVector().get(selectedRow));
			           	
			        }
			    });


		}

}