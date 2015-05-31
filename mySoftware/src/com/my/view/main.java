package com.my.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.my.dao.CookieDAO;
import com.my.model.Cookie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.Font;

public class main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    CookieDAO cookiedao = new CookieDAO();
    public String mainz = null;
    public String mainf = null;
    public String mainn = null;
    public int mainp = 0;
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		//table = new JTable();
		//////////////////////////
		final List<Cookie> list = cookiedao.findAll();
		
		//System.out.print("haha");
		
		////////////////////
		 //添加表头元素
		 final Vector headVector = new Vector();
		 headVector.add("商品编号");
		 headVector.add("主料");
		 headVector.add("名称");
		 headVector.add("价格");
	
	  
	     Vector data = new Vector();
		
	
		/////////////////////////////////////
		JLabel label = new JLabel("\u4E3B\u6599 \uFF1A");
		
		JLabel label_1 = new JLabel("\u8F85\u6599\uFF1A");
		
		
		Vector v = new Vector();
		for(int i=0;i<list.size();i++){
			v.add(list.get(i).getIngredient());
		}
		final JComboBox comboBox = new JComboBox(v);//主
		 
		Vector v1 = new Vector();
		v1.add("辣椒酱");
		v1.add("芝麻酱");
		v1.add("番茄酱");
		final JComboBox comboBox_1 = new JComboBox(v1);
		
		JButton button = new JButton("\u6253\u5370\u53D1\u7968");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//打印发票
				int k = 0;
				k = table.getSelectedRow();
				int id = (int) table.getValueAt(k,0);
				String mainz=(String) table.getValueAt(k,1);
				String mainn=(String) table.getValueAt(k,2);
				int mainp = (int) table.getValueAt(k,3);
				System.out.print("\n++++++++++++++鸡蛋灌饼系统++++++++++++++++++\n");
				System.out.print("订单号："+id+"\n名称："+mainn+"\n价格："+mainp+"\n");
				System.out.print("++++++++++++++谢谢惠顾++++++++++++++++++\n");
			}
		});
		
		JButton button_1 = new JButton("\u5237\u65B0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//刷新
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//System.out.print(table.getSelectedRow());
					}
				});
			}
		});
		final DefaultTableModel tableModel = new DefaultTableModel(data, headVector);
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u8BA2\u5355");
		btnNewButton.addActionListener(new ActionListener() {//添加订单
			public void actionPerformed(ActionEvent e) {
				mainz = comboBox.getSelectedItem().toString();
				mainf = comboBox_1.getSelectedItem().toString();
				/////////////////
				Vector rowData1 = new Vector();
				Vector data = new Vector();
			    
			    int j=0;
			    for(;j<list.size();j++){
			    	if(mainz == list.get(j).getIngredient()){
			    		mainn = list.get(j).getName();
			    		mainp = list.get(j).getPrice();
			    	}
			    	
			    }
			    int i =100;
			    i+=(Math.random()*100);
				//开始表中的数据是1,2,3,4
				rowData1.add(i);
				rowData1.add(mainz);
				rowData1.add(mainn);
				rowData1.add(mainp);
				data.add(rowData1);
				//DefaultTableModel tableModel = new DefaultTableModel(data, headVector);
				tableModel.addRow(rowData1);
				//DefaultTableModel tableModel = new DefaultTableModel(data, headVector);
				//table = new JTable(tableModel);
			}
		});
		//使用DefaultTableModel构建表格
				//DefaultTableModel tableModel = new DefaultTableModel(data, headVector);
				table = new JTable(tableModel);
		
		JLabel label_2 = new JLabel("\u81EA\u52A8\u5356\u997C\u7CFB\u7EDF");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
				/////////////////////////////////////
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(32)
					.addComponent(button_1)
					.addGap(33)
					.addComponent(button)
					.addGap(96))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(label_2)
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(btnNewButton))
					.addGap(28))
		);
		
		//table = new JTable();
		//table.addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mouseClicked(MouseEvent e) {
		//	}
		//});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
