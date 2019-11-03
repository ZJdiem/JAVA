package JavaDraw;

import JavaDraw.factory.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Author: Z&J
 * E-mail: 320647879@qq.com
 * Time: 2018/12/2 16:11
 * 类描述-Description:
 * *
 */
public class DrawJFrame extends JFrame implements ActionListener
{
    private JComboBox<Integer> combox_size;//线条宽度组合框
    private JRadioButton radio[];	 		 //单选按钮数组
    private DrawCanvas canvas;
    private String[] s;
    public DrawJFrame()
    {
        super("画图小工具！！！");
        this.setSize(1200,900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JToolBar toolbar=new JToolBar();	 //工具栏，默认水平方向
        this.getContentPane().add(toolbar, "North");//工具栏添加到框架北

        JLabel lable=new JLabel("粗细");
        toolbar.add(lable);
        Integer sizes[]= {1,2,3,4,5,6,};    //画线大小
        this.combox_size= new JComboBox<>(sizes);
        this.combox_size.setMaximumSize(new Dimension(50, 30));
        this.combox_size.setEditable(true);  //设置组合框可编辑
        this.combox_size.addActionListener(this);
        toolbar.add(this.combox_size);

        toolbar.addSeparator(new Dimension(50, 30));
        s= new String[]{"直线", "矩形", "圆", "曲线","三角形"};       //单选按钮数组
        ButtonGroup bgroup=new ButtonGroup();
        this.radio=new JRadioButton[s.length];
        for(int i=0;i<s.length;i++)
        {
            this.radio[i]=new JRadioButton(s[i]);
            this.radio[i].addActionListener(this);
            bgroup.add(this.radio[i]);
            toolbar.add(this.radio[i]);
        }
        this.radio[0].setSelected(true);

        toolbar.addSeparator(new Dimension(50, 30));
        JButton color_button=new JButton("选择颜色");//颜色按钮
        JButton eraser_button=new JButton("橡皮檫");
        JButton new_button=new JButton("新建");
        color_button.addActionListener(this);
        eraser_button.addActionListener(this);
        new_button.addActionListener(this);
        toolbar.add(color_button);
        toolbar.addSeparator(new Dimension(60, 30));
        toolbar.add(eraser_button);
        toolbar.addSeparator(new Dimension(60, 30));
        toolbar.add(new_button);

        this.canvas =new DrawCanvas();
        canvas.setFactory(new LineFactory(canvas));
        this.getContentPane().add(canvas);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() instanceof JComboBox<?>)
        {
            try
            {
                Object obj=this.combox_size.getSelectedItem();//获取输入值
                if(obj instanceof Integer)
                    canvas.style.size=((Integer)obj).intValue();
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this, "\""+ this.combox_size.getSelectedItem() +"\" 不能转换成整数，请重新输入！");
            }
        }
        if(ae.getActionCommand().equals("选择颜色"))
        {
            canvas.style.keepColor=JColorChooser.showDialog(this, "选择颜色", Color.BLACK);
        }
        if(ae.getActionCommand().equals("新建"))
        {
            this.dispose();
            new DrawJFrame();
        }

        if(ae.getActionCommand().equals("直线"))
            canvas.setFactory(new LineFactory(canvas));
        if(ae.getActionCommand().equals("矩形"))
            canvas.setFactory(new RectFactory(canvas));
        if(ae.getActionCommand().equals("圆"))
            canvas.setFactory(new OvalFactory(canvas));
        if(ae.getActionCommand().equals("三角形"))
            canvas.setFactory(new TriangleFactory(canvas));
        if(ae.getActionCommand().equals("曲线"))
            canvas.setFactory(new CurveFactory(canvas));
        if(ae.getActionCommand().equals("橡皮檫"))
            canvas.setFactory(new EraserFactory(canvas));
    }
    public static void main(String[] args)
    {
        new DrawJFrame();
    }
}