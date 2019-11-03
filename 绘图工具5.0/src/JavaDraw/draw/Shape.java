package JavaDraw.draw;

import JavaDraw.Style;
import java.awt.*;

/**
 * Author: Z&J
 * E-mail: 320647879@qq.com
 * Time: 2018/12/1 0:37
 * 类描述-Description:
 * *
 */
public abstract class Shape
{
    Point start,end;
    public Style style;
    public void setStart(Point start)
    {
        this.start = start;
    }
    public void setEnd(Point end)
    {
        this.end = end;
    }

    public abstract void draw(Graphics2D g);
    public abstract void setStyle(Style style);
}