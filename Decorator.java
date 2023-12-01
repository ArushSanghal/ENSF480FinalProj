import java.awt.Graphics;

public class Decorator implements Component {

    private Component cmp;
    private int width;
    public int height;


    @Override
    public void draw(Graphics g) {
        
    }


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public Component getCmp() {
        return cmp;
    }


    public void setCmp(Component cmp) {
        this.cmp = cmp;
    }

}