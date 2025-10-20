import java.io.File;
import java.util.Scanner;

class Parser {
        String commandName;
        String[] args;

        public boolean parse(String input){
            if (input.isEmpty() || input.trim().isEmpty()){
                return false;
            }
            String[] in = input.trim().split(" ");

            commandName = in[0];
            args = new String[in.length - 1];

            for(int i=1; i<in.length;i++){
                args[i-1] = in[i];
            }
            return  true;
        };

        public String getCommandName(){

            return commandName;
        }

        public String[] getArgs(){
            if (args == null){
                return new String[0];
            }

            return args;
        }
;
    }
 class Terminal {

     Parser parser = new Parser();
     Scanner scanner = new Scanner(System.in);
     File current=new File(System.getProperty("user.dir"));

    public String pwd(){
        return current.getAbsolutePath();
    }

    public void cd(String[] args){
        if (args.length == 0){

        }

    }

    public void chooseCommandAction(){
        System.out.print("> ");
        String input = scanner.nextLine();
        ;
        if (!parser.parse(input)){
            System.out.println("Invalid command");
        }

        if (parser.getCommandName().equals("pwd")){
            System.out.println(pwd());

        } else if (parser.getCommandName().equals("cd")) {
            cd(parser.getArgs());

        } else if (parser.getCommandName().equals("ls")) {

        } else if (parser.getCommandName().equals("mkdir")) {

        } else if (parser.getCommandName().equals("rmkdir")) {

        } else if (parser.getCommandName().equals("touch")) {

        } else if (parser.getCommandName().equals("rm")) {

        } else if (parser.getCommandName().equals("cat")) {

        } else if (parser.getCommandName().equals("wc")) {

        } else if (parser.getCommandName().equals("cp")) {

        } else if (parser.getCommandName().equals(">")) {

        } else if (parser.getCommandName().equals("exit")){
            System.out.println("Bye");
            System.exit(0);

        }
        else{
            System.out.println("Unknown command: " + parser.commandName);
        }
    }
    public static void main(String[] args){
        Terminal terminal = new Terminal();
        while(true){
            terminal.chooseCommandAction();
        }

    }
}


