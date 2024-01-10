package model;

import java.util.List;

import manager.TaskManager;

public class Console {
    
    private Menu menu;
    private boolean quit;
    private TaskManager taskManager;
    
    /* Constructor vazio */
    public Console() {

        this.quit = false;

        this.menu = new Menu();
        this.menu.addOption("CREATE", 0);
        this.menu.addOption("OPEN", 1);
        this.menu.addOption("EDIT", 1);
        this.menu.addOption("REMOVE", 1);
        this.menu.addOption("LIST", 1);
        this.menu.addOption("HELP", 0);
        this.menu.addOption("QUIT", 0);
    }

    /* Corre a consola de comandos */
    public void run() {
        /* Corre a consola enquanto houver ligação */
        while (!this.quit) {
            this.menu.readCommand();
            this.readArguments(this.menu.getArguments());   
        }
    }

    /* Lê os argumentos obtidos na leitura de comandos */
    private void readArguments(List<String> args) {

        /* Procura pelo comando nos argumentos */
        String cmd = args.get(0);

        /* Handler do comando "HELP" */
        if (cmd.equals("HELP")) {
            this.menu.display();
        }
        
        /* Handler do comando "QUIT" */
        if (cmd.equals("QUIT")) {
            this.quit = true;
            System.out.println("Exiting...");
            System.exit(1);
        }

        /* Handler do comando "CREATE" */
        if (cmd.equals("CREATE")) {
            this.taskManager.createTask();
        }

        if (cmd.equals("EDIT")) {
            if (!this.menu.checkNumberArgs(1))
                System.out.println("Invalid arguments! Type HELP to get more information...");
            else {
                this.taskManager.editTask(args.get(1));
            }
        }

        if (cmd.equals("REMOVE")) {
            if (!this.menu.checkNumberArgs(1))
                System.out.println("Invalid arguments! Type HELP to get more information...");
            else {
                this.taskManager.removeTask(args.get(1));
            }
        }

        if (cmd.equals("OPEN")) {
            if (!this.menu.checkNumberArgs(1))
                System.out.println("Invalid arguments! Type HELP to get more information...");
                else {
                    this.taskManager.openTask(args.get(1));
                }
        }

        if (cmd.equals("LIST")) {
            if (!this.menu.checkNumberArgs(0))
                System.out.println("Invalid arguments! Type HELP to get more information...");
                else {
                    this.taskManager.listTasks();
                }
        }
    }
}
