package JavaDraw.factory;

import JavaDraw.DrawCanvas;
import JavaDraw.draw.DrawLine;
import JavaDraw.draw.Shape;
/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月20日 21:06
 * 类描述-Description：
 */
public class LineFactory extends ShapeFactory
{
    private DrawLine line;
    public LineFactory(DrawCanvas canvas)
    {
        super(canvas);
    }
    @Override
    public Shape newShape()
    {
        line=new DrawLine();
        return line;
    }
}