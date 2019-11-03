package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawOval;
import JavaDraw.draw.Shape;
/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月22日 13:30
 * 类描述-Description：
 */
public class OvalFactory extends ShapeFactory
{
    DrawOval oval;
    public OvalFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public Shape newShape()
    {
        oval=new DrawOval();
        return oval;
    }
}