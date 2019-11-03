package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawTriangle;
import JavaDraw.draw.Shape;
/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月27日 14:15
 * 类描述-Description：
 */
public class TriangleFactory extends ShapeFactory
{
    DrawTriangle triangle;
    public TriangleFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public Shape newShape()
    {
        triangle=new DrawTriangle();
        return triangle;
    }
}