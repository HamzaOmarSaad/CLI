import java.util.Scanner;

class Parser {
        String commandName;
        String[] args;

        public boolean parse(String input){
            if (input.isEmpty()){
                return false;
            }
            String[] in = input.trim().split(" ");
            commandName = in[0];
            args = new String[in.length - 1];
            for(int i=1; i<in.length;i++){
                args[i] = in[i];
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

    public String pwd(){
        return "pwd";
    }

    public void cd(String[] args){
        System.out.println("cd");
    }

    public void chooseCommandAction(){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        parser.parse(input);

        if (parser.getCommandName().equals("pwd")){
            System.out.println( pwd());
        } else if (parser.getCommandName().equals("cd")) {
            cd(parser.getArgs());

        } else if (parser.getCommandName().equals("exit")){
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


