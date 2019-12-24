package com.example.brydinh.ceg4410_hw2;


import java.util.Stack;

public class CommandQ {

    private static CommandQ instance;

    private CommandQ()
    {
        if(instance == null)
        {
            instance = new CommandQ();
        }
    }

    private static Stack<Command> commandsDone;
    private static Stack<Command> commandsUndone;

    public static void push(Command c)
    {
        commandsDone.push(c);
    }

    public static void undo ()
    {
        Command c = commandsDone.pop();
        c.undoIt();
        commandsUndone.push(c);
    }

    public static CommandQ GetInstance()
    {
        return instance;
    }


}
