package br.com.raphaelfury.core.panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("static-access")
public class PanelBuilder {

	private String name;
	private final String titleName;
	private JOptionPane pane;
	private int time;

	public PanelBuilder(String name) {
		setName(name);
		this.titleName = getName() + " - ";
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
	
	public PanelBuilder longMessage(String longMessage, String title, int code) {
	    SwingUtilities.invokeLater(() -> {
	        JTextArea textArea = new JTextArea(15, 50);
	        textArea.setFont(new Font("Monospace", Font.TRUETYPE_FONT, 15));
	        textArea.setText(longMessage);
	        textArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        getPane().showMessageDialog(null, scrollPane, titleName + title, code);
	    });
	    return this;
	}

	public PanelBuilder temp(Object message, String title, int code, int seconds) {
		JDialog dialog = getPane().createDialog(titleName + title + getTime());

		dialog.setModal(true);
		Timer timer = new Timer(seconds * 1000, new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				setTime(seconds - 1);
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
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JDialog pane = getPane().createDialog("testezitos");
		pane.setModal(true);
		getPane().setMessage("KASDOa");
		pane.setVisible(true);
		return this;
	}
	
	public PanelBuilder scroll() {
		JTextArea textArea = new JTextArea("TESTE: INSIRA");
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "textarea", JOptionPane.YES_NO_OPTION);
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Object confirmBox() {
		JOptionPane box = new JOptionPane("Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
		JDialog dialog = box.createDialog(titleName);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				super.componentShown(e);
				Timer t;
				t = new Timer(7000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});
				t.setRepeats(false);
				t.start();
			}
		});
		dialog.setVisible(true);
		System.out.println(box.getValue());
		System.out.println("Pronto!");
		dialog.dispose();
		
		return box.getValue();
	}
	
	public void displayWrongOption() {
		JOptionPane.showMessageDialog(null, "Esta opção não é válida", "Erro", 0);
	}

	public void displayFinish() {
		JOptionPane.showMessageDialog(null, "Fim do programa", "Encerrando", 2);
	}

}
