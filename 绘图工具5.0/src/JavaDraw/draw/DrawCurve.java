package JavaDraw.draw;

import JavaDraw.Style;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：5.0
 * 创建日期：2019/10/17 21:58
 * 类描述-Description：
 */
public class DrawCurve extends Shape
{
    private List<Point> points=new ArrayList<>();//把鼠标移动时的点记录下来
    public void addPoint(Point point)
    {
        points.add(point);
    }
    @Override
    public void draw(Graphics2D g)
    {
        Point start=points.get(0);
        for (Point end:points) //每次更新调用draw函数时，重绘记录下来的点
        {
            g.setStroke(new BasicStroke(style.size));
            g.setColor(style.color);
            g.drawLine(start.x,start.y,end.x,end.y);
            start=end;
        }
    }
    @Override
    public void setStyle(Style style)
    {
        this.style=style;
    }
}