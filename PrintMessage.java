public class PrintMessage implements ILog {

    public void info(String name, String msg) {
        System.out.println("-> " + name + ": " + msg);
    }

    public void error(String name, String msg, String info) {
        String result = "[x] " + name + ": " + msg;
        if (info != null) {
            result = result + " (" + info + ")";
        }
        System.out.println(result);
    }

    public void warning(String name, String msg) {
        System.out.println("[!] " + name + ": " + msg);
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

}