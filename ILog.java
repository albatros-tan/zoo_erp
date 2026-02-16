public interface ILog {

    public void info(String name, String msg);

    public void error(String name, String msg, String info);

    public void warning(String name, String msg);

    public void printMsg(String msg);
}