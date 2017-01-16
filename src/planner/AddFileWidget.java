package planner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.io.*;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;


public class AddFileWidget extends JPanel implements ActionListener{

	private ClassList clist;
	private JButton open_button;
	private JFileChooser fc;

	public AddFileWidget(ClassList clist){
		this.clist = clist;
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setCurrentDirectory(new java.io.File("."));

		
//		ImageIcon imageIcon = createImageIcon("http://www.wpclipart.com/computer/icons/folders/yellow_file_folder_T.png");
		ImageIcon imageIcon = new ImageIcon("text/folder.png");// load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);

		open_button = new JButton("Import Classes", imageIcon);
		open_button.addActionListener(this);
		add(open_button, BorderLayout.CENTER);

		fc.setDialogTitle("Upload Class List");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
		fc.addChoosableFileFilter(filter);
		fc.setAcceptAllFileFilterUsed(false);

	}
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == open_button){
			int returnVal = fc.showOpenDialog(AddFileWidget.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				String file = fc.getSelectedFile().getAbsolutePath();
				addFileClasses(file);
			}
		}

	}

	public void addFileClasses(String fileLocation){
		String line = null;

		try {

			FileReader fileReader = 
					new FileReader(fileLocation);

			//wraping FileReader in BufferedReader for efficiency
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				clist.addClass(new AClass(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]),Integer.parseInt(words[3])));
			}   

			//close file
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileLocation + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileLocation + "'");                  

		}
	}

}
