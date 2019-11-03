package JavaDraw;

import JavaDraw.draw.Shape;
import JavaDraw.factory.ShapeFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Z&J
 * E-mail: 320647879@qq.com
 * Time: 2018/12/2 16:11
 * 类描述-Description:
 * *
 */
public class DrawCanvas extends JComponent implements MouseMotionListener, MouseListener
{
    private Shape shape;
    private ShapeFactory sf;
    public Style style;
    private List<Shape> list = new ArrayList<>();//容器类
    public DrawCanvas()
    {
        this.style=new Style(Color.BLACK,1);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        sf.mousePressed(e);//调用ShapeFactory对象的mousePressed()方法，具体画什么由其子类实现
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        sf.mouseReleased(e);
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        sf.mouseDragged(e);
    }
    //通过函数传参的形式将shape和工厂对象传入canvas中
    public void setFactory(ShapeFactory sf)
    {
        this.sf = sf;
    }
    public void setTempProduct(Shape shape)
    {
        this.shape = shape;
        this.repaint();
    }
    public void setProduct(Shape shape)
    {
        list.add(shape);
        this.repaint();
        this.shape=null;
    }
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;//Graphics2D才能设置画笔粗细。
        for (Shape d : list)
        {
            if (d != null)
                d.draw(g2);//每次更新时，会清空画布，所以把list中的图形全部重绘一遍
        }
        if (shape != null)
            shape.draw(g2);//绘图
    }
    public void update(Graphics g)
    {
        paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
    }
    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}