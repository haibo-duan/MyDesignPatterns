package com.dhb.command;

public class DeleteCommand extends Command{

	public DeleteCommand(Content c) {
		this.c = c;
	}

	Content c;

	String deleted;

	@Override
	public void doit() {
		deleted = c.msg.substring(0,5);
		c.msg = c.msg.substring(5,c.msg.length());
	}

	@Override
	public void undo() {
		c.msg = deleted + c.msg;
	}
}
