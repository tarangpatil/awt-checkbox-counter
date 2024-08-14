package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends Frame {
	static final long serialVersionUID = 0L;
	Label countDisplay, langDisplay;
	static int compsAdded = 0;
	Set<String> checks;

	public Main() {
		System.out.println("");
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		this.checks = new HashSet<String>();
		countDisplay = new Label("Favorite languages count: 0");
		countDisplay.setBounds(0, (25 * compsAdded + 40), 300, 25);
		compsAdded++;
		langDisplay = new Label("Favorite languages: []");
		langDisplay.setBounds(0, (25 * compsAdded + 40), 300, 25);
		compsAdded++;

		this.add(countDisplay);
		this.add(langDisplay);
		addCheckbox("C");
		addCheckbox("C++");
		addCheckbox("Java");
		addLabel("If any others (CANNOT BE UNDONE):");
		addTFandBtn();
	}

	public void addCheckbox(String str) {
		Checkbox c = new Checkbox(str);
		c.setBounds(0, (25 * compsAdded + 40), 300, 25);
		compsAdded++;
		this.add(c);
		c.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					checks.add(str);
				}
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					checks.remove(str);
				}
				countDisplay.setText("Favorite languages count: " + checks.size());
				langDisplay.setText("Favorite languages: " + checks);
			}
		});
	}

	public void addLabel(String str) {
		Label l = new Label(str);
		l.setBounds(0, (25 * compsAdded + 40), 300, 25);
		compsAdded++;
		this.add(l);
	}

	public void addTFandBtn() {
		TextField tf = new TextField();
		tf.setBounds(0, (25 * compsAdded + 40), 150, 25);
		this.add(tf);
		Button b = new Button("Go");
		b.setBounds(150, (25 * compsAdded + 40), 50, 25);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checks.add(tf.getText());
				countDisplay.setText("Favorite languages count: " + checks.size());
				langDisplay.setText("Favorite languages: " + checks);
			}
		});
		this.add(b);
		compsAdded++;
	}

	public static void main(String args[]) {
		new Main();
	}
}
