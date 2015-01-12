package boleto1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App {

	private static JFrame frame;
	private static JButton button;

	public static void main(String[] args) throws AWTException,
			UnsupportedFlavorException, IOException {
		App app = new App();
		app.createAndShowGUI();
	}
	
	public void paste() throws AWTException, UnsupportedFlavorException, IOException, InterruptedException{
		Thread.sleep(4000);
		Robot robot = new Robot();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("String from Clipboard:" + result);
		result = result.trim();		
		for (char car : result.toCharArray()) {
			if (Character.isDigit(car)) {
				robot.keyPress(App.type(car));
				robot.keyRelease(App.type(car));
			}
			
		}		
	}

	public void createAndShowGUI() {
		button = new JButton("Clique aqui e depois no campo a ser preenchido");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					paste();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			};
		});

		frame = new JFrame();
		frame.add(button);
		frame.setLocation(150, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static int type(char character) {
		switch (character) {
		case '0':
			return KeyEvent.VK_0;
		case '1':
			return KeyEvent.VK_1;
		case '2':
			return KeyEvent.VK_2;
		case '3':
			return KeyEvent.VK_3;
		case '4':
			return KeyEvent.VK_4;
		case '5':
			return KeyEvent.VK_5;
		case '6':
			return KeyEvent.VK_6;
		case '7':
			return KeyEvent.VK_7;
		case '8':
			return KeyEvent.VK_8;
		case '9':
			return KeyEvent.VK_9;
		}
		return 0;
	}
}
