import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Count extends JFrame {
	private JLabel lbl;
	private Timer timer;
	private final MyMessageLogger logger;
	private final File logFile = new File("d:\\mydata\\countChange.txt");
	
	
	public Count() {
		logger = new MyMessageLogger(logFile);

		
		JPanel pnl = new JPanel();
		lbl = new JLabel("1");
		JButton btn = new JButton("딸깍");
		JButton btnclose = new JButton("종료");

		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btnclose);
		add(pnl);
	 
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startTimer();
			}
		});
		
		btnclose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}



	private void startTimer() {
		if (timer != null) {
			timer.cancel();
		}

		int initialDelay = 0;
		int period = 100;

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int count = Integer.parseInt(lbl.getText());
			@Override
			public void run() {
				count++;
				lbl.setText(Integer.toString(count));
				logger.saveLog(String.format("%s - %s\n", LocalDateTime.now(), lbl.getText()));
			}
		}, initialDelay, period);
	}

	public static void main(String[] args) {
		new Count();
	}
}