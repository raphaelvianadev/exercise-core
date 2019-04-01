package br.com.raphaelfury.core.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

@SuppressWarnings("static-access")
public class PanelBuilder {
	
	private String name;
	private final String titleName;
	private JOptionPane pane;

	public PanelBuilder(String name) {
		setName(name);
		titleName = getName() + " - ";
		setPane(new JOptionPane());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JOptionPane getPane() {
		return pane;
	}

	public void setPane(JOptionPane pane) {
		this.pane = pane;
	}

	public PanelBuilder message(String message) {
		getPane().showMessageDialog(null, getName() + message);
		return this;
	}

	public PanelBuilder message(String message, String title, int code) {
		getPane().showMessageDialog(null, message, titleName + title, code);
		return this;
	}

	public PanelBuilder message(String[] message, String title, int code) {
		getPane().showMessageDialog(null, message, titleName + title, code);
		return this;
	}
	
	public PanelBuilder message(List<String> message, String title, int code) {
		getPane().showMessageDialog(null, message, titleName + title, code);
		return this;
	}

	public PanelBuilder message(StringBuilder message, String title, int code) {
		getPane().showMessageDialog(null, message.toString(), titleName + title, code);
		return this;
	}
	
	public PanelBuilder temp(Object message, String title, int code, int seconds) {
		JDialog dialog = getPane().createDialog(titleName + title);
		
		dialog.setModal(true);
		Timer timer = new Timer(seconds * 1000, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				dialog.dispose();
			}
		});
		timer.start();
		getPane().setMessageType(code);
		getPane().setMessage(message);
		dialog.setVisible(true);
		timer.stop();
		return this;
	}
	
	public PanelBuilder temp(int seconds, int a) {
		try{
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		JDialog pane = getPane().createDialog("testezitos");
		pane.setModal(true);
		getPane().setMessage("KASDOa");
		pane.setVisible(true);
		return this;
	}
	
	public int confirm(String message) {
		return getPane().showConfirmDialog(null, message);
	}
	
	public int confirm(String message, String title, int option) {
		return getPane().showConfirmDialog(null, message, titleName + title, option);
	}
	
	public int confirm(String message, String title, int option, int messageType) {
		return getPane().showConfirmDialog(null, message, titleName + title, option, messageType);
	}
	
	public String input(String message) {
		return getPane().showInputDialog(null, message);
	}
	
	public String input(String message, String initialSelectionValue) {
		return getPane().showInputDialog(null, message, initialSelectionValue);
	}
	
	public String input(String message, String title, int messageType) {
		return getPane().showInputDialog(null, message, titleName + title, messageType);
	}
	
	public JOptionPane toOptionPane() {
		return pane;
	}

}
