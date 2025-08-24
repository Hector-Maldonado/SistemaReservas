package Observer;

public class ClientObserver implements Observer {
    private String name;

    public ClientObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notificación para " + name + ": " + message);
    }
}
