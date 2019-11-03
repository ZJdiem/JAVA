package JavaDraw.draw;

import JavaDraw.Style;
import java.awt.*;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月27日 14:04
 * 类描述-Description：
 */
public class DrawTriangle extends Shape
{
    @Override
    public void draw(Graphics2D g)
    {
        g.setStroke(new BasicStroke(style.size));//设置画笔粗细
        g.setColor(style.color);
        g.drawLine(start.x,start.y,end.x,end.y);
        g.drawLine(start.x,start.y,2*start.x-end.x,end.y);
        g.drawLine(2*start.x-end.x,end.y,end.x,end.y);
    }
    @Override
    public void setStyle(Style style)
    {
        this.style=style;
    }
}
