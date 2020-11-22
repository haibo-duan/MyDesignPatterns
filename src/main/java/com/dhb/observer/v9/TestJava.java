package com.dhb.observer.v9;

import java.util.ArrayList;
import java.util.List;

interface ActionListener {
	public void actionPerformed(ActionEvent e);
}

public class TestJava {

	public static void main(String[] args) {
		Button1 b = new Button1();
		b.addActionListener(new MyActionListenerA());
		b.addActionListener(new MyActionListenerB());
		b.buttonPressed();
	}


}

class Button1 {
	private List<ActionListener> actionListeners = new ArrayList<>();

	public void buttonPressed() {
		ActionEvent e = new ActionEvent(System.currentTimeMillis(), this);
		for (int i = 0; i < actionListeners.size(); i++) {
			ActionListener l = actionListeners.get(i);
			l.actionPerformed(e);
		}
	}

	public void addActionListener(ActionListener l) {
		actionListeners.add(l);
	}
}

class MyActionListenerA implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("button pressed!");
	}
}

class MyActionListenerB implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("button pressed 2!");
	}
}

class ActionEvent {
	long when;
	Object source;

	public ActionEvent(long when, Object source) {
		super();
		this.when = when;
		this.source = source;
	}

	public long getWhen() {
		return when;
	}

	public void setWhen(long when) {
		this.when = when;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}
}