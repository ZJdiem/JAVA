package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawRect;
import JavaDraw.draw.Shape;
/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月22日 13:22
 * 类描述-Description：
 */
public class RectFactory extends ShapeFactory
{
    DrawRect rect;
    public RectFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public Shape newShape()
    {
        rect=new DrawRect();
        return rect;
    }
}