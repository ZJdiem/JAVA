package JavaDraw.draw;

import JavaDraw.Style;
import java.awt.*;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019年09月17日 17:07
 * 类描述-Description：
 */
public class DrawRect extends Shape
{
    @Override
    public void draw(Graphics2D g)
    {
        g.setStroke(new BasicStroke(style.size));//设置画笔粗细
        g.setColor(style.color);
        g.drawRect(start.x, start.y, Math.abs(end.x-start.x), Math.abs(end.y-start.y));
    }
    @Override
    public void setStyle(Style style)
    {
        this.style=style;
    }
}
