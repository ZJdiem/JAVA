package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawCurve;
import JavaDraw.draw.Shape;
import java.awt.event.MouseEvent;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月27日 9:39
 * 类描述-Description：
 */
public class EraserFactory extends ShapeFactory
{
    DrawCurve eraser;
    public EraserFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        eraser=new DrawCurve();
        style=canvas.style.clone();
        style.color=canvas.getBackground();
        eraser.setStyle(style);
        eraser.addPoint(e.getPoint());
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        eraser.addPoint(e.getPoint());
        canvas.setTempProduct(eraser);
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        eraser.addPoint(e.getPoint());
        canvas.setProduct(eraser);
        style=null;
    }
    @Override
    public Shape newShape()
    {
        return null;
    }
}