package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawCurve;
import JavaDraw.draw.Shape;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月22日 12:00
 * 类描述-Description：工厂模式，每生产一个对象，先创建一个生产该对象的工厂。
 */
public class CurveFactory extends ShapeFactory
{
    DrawCurve curve;
    public CurveFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        curve=new DrawCurve();
        style=canvas.style.clone();
        curve.addPoint(e.getPoint());
        curve.setStyle(style);
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        style.color=Color.lightGray;
        curve.addPoint(e.getPoint());//把鼠标移动时的点记录下来，记录到curve对象中的points容器中
        canvas.setTempProduct(curve);//由于是画曲线，所以需要把鼠标移动的时候产生的对象放到容器里去
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        style.color=style.keepColor;
        curve.addPoint(e.getPoint());
        canvas.setProduct(curve);
        style=null;
    }
    @Override
    public Shape newShape()
    {
        return null;
    }
}