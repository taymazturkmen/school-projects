package ex05;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BoxEditor extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextArea editArea;
	JFileChooser fc = new JFileChooser();
	File file;
	Color color;
	int width;
	int height;
	int x = 0;
	int y = 0;
	DrawPane pictureArea = new DrawPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxEditor frame = new BoxEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoxEditor() {
		CardLayout cl = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem newButton = new JMenuItem("New");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BoxEditor().setVisible(true);
			}
		});
		fileMenu.add(newButton);
		JMenuItem openButton = new JMenuItem("Open");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int returnVal = fc.showOpenDialog(BoxEditor.this);
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			             file = fc.getSelectedFile();
			             FileReader reader = null;
						try {
							reader = new FileReader(file);
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						}
			             BufferedReader br = new BufferedReader(reader);
			             try {
			            	 editArea.read(br, file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			        }		
			       }
		});
		fileMenu.add(openButton);
		JMenuItem saveButton = new JMenuItem("Save");
		fileMenu.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int retval = fc.showSaveDialog(BoxEditor.this);
			    if (retval == JFileChooser.APPROVE_OPTION) {
			      File file = fc.getSelectedFile();
			      if (file == null) {
			        return;
			      }
			      if (!file.getName().toLowerCase().endsWith(".txt")) {
			        file = new File(file.getParentFile(), file.getName() + ".txt");
			      }
			      try {
			    	  editArea.write(new OutputStreamWriter(new FileOutputStream(file),
			            "utf-8"));
			        Desktop.getDesktop().open(file);
			      } catch (Exception f) {
			        f.printStackTrace();
			      }
			    }		
			       }
		});
		
		fileMenu.add(new JSeparator());
		JMenuItem exitButton = new JMenuItem("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		fileMenu.add(exitButton);


		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel radioPanel = new JPanel();
		contentPane.add(radioPanel, BorderLayout.NORTH);
		JPanel textPanel = new JPanel();
		contentPane.add(textPanel, BorderLayout.CENTER);
		textPanel.setLayout(cl);
		
		
		
		editArea = new JTextArea();
	    editArea.setFont(new Font("AverageMono", Font.PLAIN, 15));

		textPanel.add(editArea, "1");
		
		

		JRadioButton editButton = new JRadioButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(textPanel, "1");
			}
		});
		editButton.setSelected(true);
		buttonGroup.add(editButton);
		radioPanel.add(editButton);
		
		JRadioButton pictureButton = new JRadioButton("Picture");
		pictureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = editArea.getText();
				String[] resultArr = result.split(":| |\\r?\\n");
				System.out.println(result);
				if(resultArr.length>=3) {
					for(int i = 0; i<resultArr.length-2;i++) {
						String colorStr = resultArr[i];
						 color = Color.decode(colorStr);
						 width = Integer.valueOf(resultArr[i+1]);
						 height = Integer.valueOf(resultArr[i+2]);
						i = i+2;
						pictureArea.addRectangle(color, width, height, x, y);
					}
					textPanel.add(pictureArea, "2");
					cl.show(textPanel, "2");
				}
	
				
			}
		});
		buttonGroup.add(pictureButton);
		radioPanel.add(pictureButton);
		
		pack();
	}

}
