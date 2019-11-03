package JavaDraw;

import java.awt.*;

/**
 * Author：Z&J
 * E-mail: 320647879@qq.com
 * 版本：1.0
 * 创建日期：2019/10/12 11:20
 * 类描述-Description：
 */
public class Style implements Cloneable
{
    public int size;
    public Color color;
    public Color keepColor;
    public Style(Color color,int size)
    {
        this.color=color;
        this.size=size;
    }
    public Style clone()
    {
        Style s=null;
        try
        {
            s= (Style) super.clone();
        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return s;
    }
}