package g2e.navigatioindrawer.utility;

/**
 * Created by brpadhy on 2/3/2016.
 */
public class ObjectDrawerItem {
    private int icon;
    private String name;
    private String notification;

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }


    public ObjectDrawerItem(int icon, String name, String notif) {
        this.icon = icon;
        this.name = name;
        this.notification = notif;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
