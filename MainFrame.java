package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MainFrame1 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	public MainFrame1() {

		
		// 添加人物组件
		wolfInit();
		// 添加箱子（被推动）组件
		boxInit();
		// 添加障碍组件
		treeInit();
		// 添加笼子（目的）组件
		targetInit();
		// 添加背景
		backGroundInit();
		// 设置窗口
		setMainFrameUI();
		// 监听键盘
		this.addKeyListener(this);
	}

	JLabel[][] boxs = new JLabel[12][16];

	// 1代表障碍，0代表空地，4代表箱子，8代表目标，箱子进入目标代表12
	int[][] datas = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 8, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 8, 4, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 1, 8, 0, 0, 0, 4, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 	
			};

	int wx;
	int wy;
	int tar = 0;
	
	int box1_wx = 7;
	int box1_wy = 4;
	int box2_wx = 6;
	int box2_wy = 7;
	int box3_wx = 9;
	int box3_wy = 8;
	
	int target1_wx = 5;
	int target1_wy = 6;
	int target2_wx = 5;
	int target2_wy = 7;
	int target3_wx = 5;
	int target3_wy = 8;

	private void treeInit() {
		// 遍历二维数组
		Icon icon = new ImageIcon("src/1.jpg");
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] == 1) {
					JLabel lab_tree = new JLabel(icon);
					lab_tree.setBounds(j * 50+1, i * 50+1, 49, 49);
					this.add(lab_tree);
				}
			}
		}
	}

	private void victory() {
		if (tar == 3) {
			System.out.println("胜利");
			JOptionPane.showMessageDialog(MainFrame1.this, "<html><body>胜利！<br/>然而...并没有什么惊喜...<br/></body></html>");
			setVisible(false);
			new MainFrame1();
		}
	}

	private void targetInit() {

		ImageIcon icon = new ImageIcon("src/longzi.png");
		JLabel lab_target1 = new JLabel(icon);
		lab_target1.setBounds(target1_wx *50, target1_wy*50, 50, 50);
		this.add(lab_target1);

		JLabel lab_target2 = new JLabel(icon);
		lab_target2.setBounds(target2_wx *50, target2_wy*50, 50, 50);
		this.add(lab_target2);

		JLabel lab_target3 = new JLabel(icon);
		lab_target3.setBounds(target3_wx *50, target3_wy*50, 50, 50);
		this.add(lab_target3);
	}

	private void boxInit() {
		Icon icon = new ImageIcon("src/tom.png");
		// 上
		JLabel lab_box1 = new JLabel(icon);
		lab_box1.setBounds(box1_wx* 50, box1_wy * 50, 50, 50);
		this.add(lab_box1);
		boxs[box1_wy][box1_wx] = lab_box1;
		// 中
		JLabel lab_box2 = new JLabel(icon);
		lab_box2.setBounds(box2_wx* 50, box2_wy * 50, 50, 50);
		this.add(lab_box2);
		boxs[box2_wy][box2_wx]= lab_box2;
		// 下
		JLabel lab_box3 = new JLabel(icon);
		lab_box3.setBounds(box3_wx* 50, box3_wy * 50, 50, 50);
		this.add(lab_box3);
		boxs[box3_wy][box3_wx] = lab_box3;
	}

	private void wolfInit() {
		wx = 6;
		wy = 3;
		Icon icon = new ImageIcon("src/-10.png");
		lab_wolf = new JLabel(icon);
		lab_wolf.setBounds(wx * 50, wy * 50, 50, 50);
		this.add(lab_wolf);
	}

	JLabel lab_wolf;

	// 初始化窗体
	private void setMainFrameUI() {
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(815, 640);
		this.setLocation(500, 250);
		this.setTitle("推箱子 V1.0 - Erbenner的初代作品");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 设置背景backGroundInit()
	private void backGroundInit() {
		Icon icon = new ImageIcon("src/floor.jpg");
		JLabel lab_bg = new JLabel(icon);
		lab_bg.setBounds(0, 0, 800, 600);
		this.add(lab_bg);
	}

	// 设置监听
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == 37) {// 左
			// <------------第一位为1------------>
			if (datas[wy][wx - 1] == 1) {
				return;
			}
			// <------------第一位为1------------>

			// <------------第一位为0或8------------>
			if (datas[wy][wx - 1] == 0 || datas[wy][wx - 1] == 8) {
				// 正常走
				wx--;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x - 50, y);
				Icon icon = new ImageIcon("src/01.png");
				lab_wolf.setIcon(icon);
				return;
			}
			// <------------第一位为0或8------------>

			// <------------第一位为4------------>
			if (datas[wy][wx - 1] == 4) {
				// 箱子+空地
				if (datas[wy][wx - 2] == 0) {
					// 进入了这里！！
					datas[wy][wx - 1] = 0;
					datas[wy][wx - 2] = 4;
				}
				// 箱子+障碍 || 箱子+箱子 || 箱子+完成
				else if (datas[wy][wx - 2] == 1 || datas[wy][wx - 2] == 4 || datas[wy][wx - 2] == 12) {
					return;
				}
				// 箱子+目标
				else if (datas[wy][wx - 2] == 8) {
					datas[wy][wx - 1] = 0;
					datas[wy][wx - 2] = 12;
					tar++;
					System.out.println("抓住了一个！");
				}
			}
			// <------------第一位为4------------>

			// <------------第一位为12------------>
			if (datas[wy][wx - 1] == 12) {
				// 完成+空地
				if (datas[wy][wx - 2] == 0) {
					datas[wy][wx - 1] = 8;
					datas[wy][wx - 2] = 4;
					tar--;
					System.out.println("你放走了一个！");
				}
				// 完成+障碍 || 完成+箱子|| 完成+完成
				else if (datas[wy][wx - 2] == 1 || datas[wy][wx - 2] == 4 || datas[wy][wx - 2] == 12) {
					return;
				}
				// 完成+目标
				else if (datas[wy][wx - 2] == 8) {
					datas[wy][wx - 1] = 8;
					datas[wy][wx - 2] = 12;
				}
			}
			// <------------第一位为12------------>
			boxs[wy][wx - 1].setLocation(wx * 50 - 100, wy * 50);
			boxs[wy][wx - 2] = boxs[wy][wx - 1];
			boxs[wy][wx - 1] = null;
			wx--;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x - 50, y);
			Icon icon = new ImageIcon("src/01.png");
			lab_wolf.setIcon(icon);
			victory();
			return;
		}

		if (key == 38) { // 上
			if (datas[wy - 1][wx] == 1) {
				return;
			}

			if (datas[wy - 1][wx] == 0 || datas[wy - 1][wx] == 8) {
				// 正常走
				if (datas[wy - 1][wx] == 8){
					System.out.println("我进入了笼子！");
				}
				wy--;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y - 50);
				Icon icon = new ImageIcon("src/10.png");
				lab_wolf.setIcon(icon);
				return;
			}

			// 推箱子
			if (datas[wy - 1][wx] == 4) {
				// 箱子+空地
				if (datas[wy - 2][wx] == 0) {
					datas[wy - 1][wx] = 0;
					datas[wy - 2][wx] = 4;
				}
				// 箱子+障碍 || 箱子+箱子 || 箱子+完成
				else if (datas[wy - 2][wx] == 1 || datas[wy - 2][wx] == 4 || datas[wy - 2][wx] == 12) {
					return;
				}
				// 箱子+目标
				else if (datas[wy - 2][wx] == 8) {
					datas[wy - 1][wx] = 0;
					datas[wy - 2][wx] = 12;
					tar++;
					System.out.println("抓住了一个！");
				}
			}

			// 推完成
			if (datas[wy - 1][wx] == 12) {
				// 完成+空地
				if (datas[wy - 2][wx] == 0) {
					datas[wy - 1][wx] = 8;
					datas[wy - 2][wx] = 4;
					tar--;
					System.out.println("你放走了一个！");
				}
				// 完成+障碍 || 完成+箱子|| 完成+完成
				else if (datas[wy - 2][wx] == 1 || datas[wy - 2][wx] == 4 || datas[wy - 2][wx] == 12) {
					return;
				}
				// 完成+目标
				else if (datas[wy - 2][wx] == 8) {
					datas[wy - 1][wx] = 8;
					datas[wy - 2][wx] = 12;
				}
			}
			boxs[wy - 1][wx].setLocation(wx * 50, wy * 50 - 100);
			boxs[wy - 2][wx] = boxs[wy - 1][wx];
			boxs[wy - 1][wx] = null;
			wy--;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y - 50);
			Icon icon = new ImageIcon("src/10.png");
			lab_wolf.setIcon(icon);
			victory();
			return;
		}

		if (key == 39) {// 右

			// <------------第一位为1------------>
			if (datas[wy][wx + 1] == 1) {
				return;
			}
			// <------------第一位为1------------>

			// <------------第一位为0或8------------>
			if (datas[wy][wx + 1] == 0 || datas[wy][wx + 1] == 8) {
				// 正常走
				wx++;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x + 50, y);
				Icon icon = new ImageIcon("src/0-1.png");
				lab_wolf.setIcon(icon);
				return;
			}
			// <------------第一位为0或8------------>

			// <------------第一位为4------------>
			// 推箱子
			if (datas[wy][wx + 1] == 4) {
				// 箱子+空地
				if (datas[wy][wx + 2] == 0) {
					datas[wy][wx + 1] = 0;
					datas[wy][wx + 2] = 4;
				}
				// 箱子+障碍 || 箱子+箱子 || 箱子+完成
				else if (datas[wy][wx + 2] == 1 || datas[wy][wx + 2] == 4 || datas[wy][wx + 2] == 12) {
					return;
				}
				// 箱子+目标
				else if (datas[wy][wx + 2] == 8) {
					datas[wy][wx + 1] = 0;
					datas[wy][wx + 2] = 12;
					tar++;
					System.out.println("抓住了一个！");
				}
			}
			// <------------第一位为4------------>

			// <------------第一位为12------------>
			// 推完成
			if (datas[wy][wx + 1] == 12) {
				// 完成+空地
				if (datas[wy][wx + 2] == 0) {
					datas[wy][wx + 1] = 8;
					datas[wy][wx + 2] = 4;
					tar--;
					System.out.println("你放走了一个！");
				}
				// 完成+障碍 || 完成+箱子|| 完成+完成
				else if (datas[wy][wx + 2] == 1 || datas[wy][wx + 2] == 4 || datas[wy][wx + 2] == 12) {
					return;
				}
				// 完成+目标
				else if (datas[wy][wx + 2] == 8) {
					datas[wy][wx + 1] = 8;
					datas[wy][wx + 2] = 12;
				}
			}
			// <------------第一位为12------------>

			boxs[wy][wx + 1].setLocation(wx * 50 + 100, wy * 50);
			boxs[wy][wx + 2] = boxs[wy][wx + 1];
			boxs[wy][wx + 1] = null;
			wx++;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x + 50, y);
			Icon icon = new ImageIcon("src/0-1.png");
			lab_wolf.setIcon(icon);
			victory();
			return;
		}

		if (key == 40) {// 下
			if (datas[wy + 1][wx] == 1) {
				return;
			}

			if (datas[wy + 1][wx] == 0 || datas[wy + 1][wx] == 8) {
				// 正常走
				wy++;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y + 50);
				Icon icon = new ImageIcon("src/-10.png");
				lab_wolf.setIcon(icon);
				return;
			}

			// 推箱子
			if (datas[wy + 1][wx] == 4) {
				// 箱子+空地
				if (datas[wy + 2][wx] == 0) {
					datas[wy + 1][wx] = 0;
					datas[wy + 2][wx] = 4;
				}
				// 箱子+障碍 || 箱子+箱子 || 箱子+完成
				else if (datas[wy + 2][wx] == 1 || datas[wy + 2][wx] == 4 || datas[wy + 2][wx] == 12) {
					return;
				}
				// 箱子+目标
				else if (datas[wy + 2][wx] == 8) {
					datas[wy + 1][wx] = 0;
					datas[wy + 2][wx] = 12;
					tar++;
					System.out.println("抓住了一个！");
				}
			}

			// 推完成
			if (datas[wy + 1][wx] == 12) {
				// 完成+空地
				if (datas[wy + 2][wx] == 0) {
					datas[wy + 1][wx] = 8;
					datas[wy + 2][wx] = 4;
					tar--;
					System.out.println("你放走了一个！");
				}
				// 完成+障碍 || 完成+箱子|| 完成+完成
				if (datas[wy + 2][wx] == 1 || datas[wy + 2][wx] == 4 || datas[wy + 2][wx] == 12) {
					return;
				}
				// 完成+目标
				if (datas[wy + 2][wx] == 8) {
					datas[wy + 1][wx] = 8;
					datas[wy + 2][wx] = 12;
				}
			}
			boxs[wy + 1][wx].setLocation(wx * 50, wy * 50 + 100);
			boxs[wy + 2][wx] = boxs[wy + 1][wx];
			boxs[wy + 1][wx] = null;
			wy++;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y + 50);
			Icon icon = new ImageIcon("src/-10.png");
			lab_wolf.setIcon(icon);
			victory();
			return;
		}
		
		if (key == 82 ){
			JOptionPane.showMessageDialog(MainFrame1.this, "你选择了重新开始...");
			setVisible(false);
			new MainFrame1();
		}
		
		if (key == 66){
			JOptionPane.showMessageDialog(MainFrame1.this, "这是作弊按键，但是还没实现.");
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
