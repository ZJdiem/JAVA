package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.Style;
import JavaDraw.draw.Shape;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月20日 20:52
 * 类描述-Description：
 */
public abstract class ShapeFactory implements MouseListener, MouseMotionListener
{
    protected DrawCanvas canvas;
    protected Style style;
    private Shape shape;
    public ShapeFactory(DrawCanvas canvas)
    {
        this.canvas = canvas;
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
    @Override
    public void mousePressed(MouseEvent e)
    {
        shape=newShape();
        shape.setStart(e.getPoint());
        style=canvas.style.clone(); //使用原型模式，从canvas中克隆一个style出来
        shape.setStyle(style);
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        style.color= Color.lightGray;//绘画中颜色为灰色
        shape.setEnd(e.getPoint());
        canvas.setTempProduct(shape); //将绘画中的图形传到canvas中，绘出该图形
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        style.color=style.keepColor;//绘画完成后，恢复原来的颜色
        shape.setEnd(e.getPoint());
        canvas.setProduct(shape); //将绘出的图形放到canvas的list容器中
        style=null;
    }
    public abstract Shape newShape();
}