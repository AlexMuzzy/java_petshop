package petshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Button;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Petshopgui {
	

	private JFrame frmPetShop;
	private JTable petshopTable;
	private JTextField addName;
	private JTextField addSpecies;
	private JTextField addPrice;
	private JTextField addSex;
	private JTextField addColour;
	private JTextField addADate;
	private JTextField addSDate;
	public static addanimals adda = new addanimals();
	public static addanimal addb = new addanimal();
	public static sellanimal sella = new sellanimal();
	public static writeanimal writea = new writeanimal();
	public static computerevenue computea = new computerevenue();
	public static search search = new search();
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	public static LocalDateTime cdate = LocalDateTime.now();  
	public static DecimalFormat pricef = new DecimalFormat ("#.00");

	private JTextField textFieldComputeRevenue;
	private JTable searchTable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;	
	public ArrayList<animal> animallist = new ArrayList<animal>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Petshopgui window = new Petshopgui();
					window.frmPetShop.setVisible(true);
					search.generatespeciessearch();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 *GUI Methods
	 */
	public void updatetable (ArrayList<animal> currentlist) {
		String[] columns = new String[] {
				"Name", "Species", "Price", "Sex", "Colour", "Arrival Date", "Selling Date"
			};
		currentlist.sort(
				Comparator.comparing(
						animal::getSellingDate, Comparator.nullsFirst(
								String::compareTo))
				.thenComparing(animal::getArrivalDate));
		
	    DefaultTableModel model = new DefaultTableModel(columns, 0);
	    for (animal i : currentlist) {
	    	model.addRow(
	    			new Object[] {
	    					i.getName(),
	    					i.getSpecies(),
	    					NumberFormat.getCurrencyInstance(Locale.UK).format(i.getPrice()),
	    					i.getSex(),
	    					i.getColour(),
	    					i.getArrivalDate(),
	    					i.getSellingDate()
	    			}
	    	);
	    }
		petshopTable.setModel(model);
		searchTable.setModel(model);
	}

	/**
	 * Create the application.
	 */
	public Petshopgui() { 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPetShop = new JFrame();
		frmPetShop.setTitle("Pet Shop");
		frmPetShop.setBounds(100, 100, 1029, 712);
		frmPetShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetShop.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmPetShop.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Main Menu", null, panel_8, null);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		panel_8.add(toolBar, BorderLayout.SOUTH);
		toolBar.setFloatable(false);
		
		JButton btnAddAnimals = new JButton("Add Animals");
		btnAddAnimals.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		toolBar.add(btnAddAnimals);
		
		JButton btnSellAnimal = new JButton("Sell Animal");
		btnSellAnimal.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		toolBar.add(btnSellAnimal);
		
		JButton btnWriteAnimals = new JButton("Write Animals");
		btnWriteAnimals.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		toolBar.add(btnWriteAnimals);
		
		JPanel panel_3 = new JPanel();
		panel_8.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{137, 0};
		gbl_panel_7.rowHeights = new int[]{156, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JSplitPane splitPaneAdd = new JSplitPane();
		GridBagConstraints gbc_splitPaneAdd = new GridBagConstraints();
		gbc_splitPaneAdd.insets = new Insets(0, 0, 5, 0);
		gbc_splitPaneAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_splitPaneAdd.gridx = 0;
		gbc_splitPaneAdd.gridy = 0;
		panel_7.add(splitPaneAdd, gbc_splitPaneAdd);
		
		JPanel panel_5 = new JPanel();
		splitPaneAdd.setLeftComponent(panel_5);
		panel_5.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblName);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblSpecies);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblPrice);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblSex);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblColour);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblArrivalDate);
		
		JLabel lblSellingDate = new JLabel("Selling Date");
		lblSellingDate.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_5.add(lblSellingDate);
		
		JPanel panel_6 = new JPanel();
		splitPaneAdd.setRightComponent(panel_6);
		panel_6.setLayout(new GridLayout(7, 1, 0, 0));
		
		addName = new JTextField();
		addName.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addName);
		addName.setColumns(10);
		
		addSpecies = new JTextField();
		addSpecies.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addSpecies);
		addSpecies.setColumns(10);
		
		addPrice = new JTextField();
		addPrice.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addPrice);
		addPrice.setColumns(10);
		
		addSex = new JTextField();
		addSex.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addSex);
		addSex.setColumns(10);
		
		addColour = new JTextField();
		addColour.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addColour);
		addColour.setColumns(10);
		
		addADate = new JTextField();
		addADate.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addADate);
		addADate.setColumns(10);
		
		addSDate = new JTextField();
		addSDate.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_6.add(addSDate);
		addSDate.setColumns(10);
		
		JButton btnAddAnimal = new JButton("Add Animal");
		btnAddAnimal.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.fill = GridBagConstraints.BOTH;
		gbc_btnAddAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddAnimal.anchor = GridBagConstraints.WEST;
		gbc_btnAddAnimal.gridx = 0;
		gbc_btnAddAnimal.gridy = 1;
		panel_7.add(btnAddAnimal, gbc_btnAddAnimal);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 2;
		panel_7.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 3;
		panel_7.add(splitPane, gbc_splitPane);
		
		JLabel lblSellDate = new JLabel("Date:");
		lblSellDate.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		splitPane.setLeftComponent(lblSellDate);
		
		textFieldComputeRevenue = new JTextField();
		textFieldComputeRevenue.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		splitPane.setRightComponent(textFieldComputeRevenue);
		textFieldComputeRevenue.setColumns(10);
		
		JButton btnComputeRevenue = new JButton("Compute Revenue");
		btnComputeRevenue.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		GridBagConstraints gbc_btnComputeRevenue = new GridBagConstraints();
		gbc_btnComputeRevenue.fill = GridBagConstraints.BOTH;
		gbc_btnComputeRevenue.insets = new Insets(0, 0, 5, 0);
		gbc_btnComputeRevenue.anchor = GridBagConstraints.WEST;
		gbc_btnComputeRevenue.gridx = 0;
		gbc_btnComputeRevenue.gridy = 4;
		panel_7.add(btnComputeRevenue, gbc_btnComputeRevenue);
		

		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 13;
		panel_7.add(verticalGlue, gbc_verticalGlue);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 14;
		panel_7.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 15;
		panel_7.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblPetShop = new JLabel("Pet Shop");
		lblPetShop.setFont(new Font("Source Code Pro", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPetShop = new GridBagConstraints();
		gbc_lblPetShop.gridx = 0;
		gbc_lblPetShop.gridy = 16;
		panel_7.add(lblPetShop, gbc_lblPetShop);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane, BorderLayout.CENTER);
		
		petshopTable = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		scrollPane.setViewportView(petshopTable);
		
		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Search", null, panel_9, null);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_13.getLayout();
		flowLayout.setVgap(10);
		panel_9.add(panel_13, BorderLayout.SOUTH);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblName_1);
		
		textField = new JTextField();
		panel_13.add(textField);
		textField.setColumns(10);
		
		JLabel lblSpecies_2 = new JLabel("Species");
		lblSpecies_2.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblSpecies_2);
		
		textField_1 = new JTextField();
		panel_13.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblPrice_1);
		
		textField_2 = new JTextField();
		panel_13.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sex");
		lblNewLabel_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		panel_13.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblColour_1 = new JLabel("Colour");
		lblColour_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblColour_1);
		
		textField_4 = new JTextField();
		panel_13.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblArrivalDate_1 = new JLabel("Arrival Date");
		lblArrivalDate_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblArrivalDate_1);
		
		textField_5 = new JTextField();
		panel_13.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSellDate_1 = new JLabel("Sell Date");
		lblSellDate_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_13.add(lblSellDate_1);
		
		textField_6 = new JTextField();
		panel_13.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.NORTH);
		
		JLabel lblComonName = new JLabel("Common Name");
		panel_12.add(lblComonName);
		lblComonName.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxcommonName = new JComboBox();
		panel_12.add(comboBoxcommonName);
		
		JLabel lblNewLabel = new JLabel("kind");
		panel_12.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxkind = new JComboBox();
		panel_12.add(comboBoxkind);
		
		JLabel lblOrder = new JLabel("order");
		panel_12.add(lblOrder);
		lblOrder.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxorder = new JComboBox();
		panel_12.add(comboBoxorder);
		
		JLabel lblFamily = new JLabel("family");
		panel_12.add(lblFamily);
		lblFamily.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxfamily = new JComboBox();
		panel_12.add(comboBoxfamily);
		
		JLabel lblGenus = new JLabel("genus");
		panel_12.add(lblGenus);
		lblGenus.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxgenus = new JComboBox();
		panel_12.add(comboBoxgenus);
		
		JLabel lblSpecies_1 = new JLabel("species");
		panel_12.add(lblSpecies_1);
		lblSpecies_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxspecies = new JComboBox();
		panel_12.add(comboBoxspecies);
		
		JLabel lblNumberOfLegs = new JLabel("Number Of Legs");
		panel_12.add(lblNumberOfLegs);
		lblNumberOfLegs.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		
		JComboBox comboBoxnumberOfLegs = new JComboBox();
		panel_12.add(comboBoxnumberOfLegs);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_10.add(scrollPane_1, BorderLayout.CENTER);
		
		searchTable = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		searchTable.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(searchTable);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.SOUTH);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setFont(new Font("Source Code Pro", Font.PLAIN, 12));
		panel_11.add(btnSearch_1);
		/*
		 * Start of actionListeners
		 */
		btnAddAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				animallist = adda.filetoanimallist();
				updatetable(animallist);
			}
		});
		
		btnWriteAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					writea.writeanimaltofile(animallist);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnSellAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				animallist = sella.sellselectanimal(animallist, petshopTable.getSelectedRow());
				updatetable(animallist);
			}
		});
		
		btnAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] animalobj = new String[] {
						addName.getText(),
						addSpecies.getText(),
						addPrice.getText(),
						addSex.getText(),
						addColour.getText(),
						addADate.getText(),
						addSDate.getText()
				};
				animallist = addb.addanimaltolist(animallist, animalobj);
				updatetable(animallist);
			}
		});
		
		btnComputeRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				computea.computerevenuefromlist(animallist, textFieldComputeRevenue.getText());
			}
		});
	}
}
