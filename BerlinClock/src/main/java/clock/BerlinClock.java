package clock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;

public class BerlinClock extends JFrame {

	private static final long serialVersionUID = -2588206039237848330L;

	private JPanel contentPane;
	private SecondsPanel secondsPanel;
	private HoursTopPanel[] hoursTopPanels;
	private HoursBottomPanel[] hoursBottomPanels;
	private MinutesTopPanel[] minutesTopPanels;
	private MinutesBottomPanel[] minutesBottomPanels;
	private String timeZoneStr = "IST";//"Europe/Berlin";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BerlinClock clock = new BerlinClock();
					new Thread(new Ticker(clock)).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public BerlinClock() {
		addWindowListener(new CloseEvent(this));

		setTitle("Berlin Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Design Group Layout
		GroupLayout groupLayout = designGroupLayout();
		contentPane.setLayout(groupLayout);

		this.setVisible(true);
	}

	SecondsPanel getSecondsPanel() {
		return secondsPanel;
	}

	HoursTopPanel[] getHoursTopPanels() {
		return hoursTopPanels;
	}

	HoursBottomPanel[] getHoursBottomPanels() {
		return hoursBottomPanels;
	}

	MinutesBottomPanel[] getMinutesBottomPanels() {
		return minutesBottomPanels;
	}

	MinutesTopPanel[] getMinutesTopPanels() {
		return minutesTopPanels;
	}

	public String getTimeZone() {
		return timeZoneStr;
	}


	private GroupLayout designGroupLayout() {

		secondsPanel = new SecondsPanel();

		HoursTopPanel topHour1 = new HoursTopPanel(FourPosition.FIRST);
		HoursTopPanel topHour2 = new HoursTopPanel(FourPosition.SECOND);
		HoursTopPanel topHour3 = new HoursTopPanel(FourPosition.THIRD);
		HoursTopPanel topHour4 = new HoursTopPanel(FourPosition.FOURTH);
		hoursTopPanels = new HoursTopPanel[] { topHour1 , topHour2 , topHour3 , topHour4 }; 

		HoursBottomPanel bottomHour1 = new HoursBottomPanel(FourPosition.FIRST);
		HoursBottomPanel bottomHour2 = new HoursBottomPanel(FourPosition.SECOND);
		HoursBottomPanel bottomHour3 = new HoursBottomPanel(FourPosition.THIRD);
		HoursBottomPanel bottomHour4 = new HoursBottomPanel(FourPosition.FOURTH);
		hoursBottomPanels = new HoursBottomPanel[] { bottomHour1 , bottomHour2 , bottomHour3 , bottomHour4 };

		MinutesTopPanel minutesTopPanel1 = new MinutesTopPanel(ElevenPosition.FIRST);
		MinutesTopPanel minutesTopPanel2 = new MinutesTopPanel(ElevenPosition.SECOND);
		MinutesTopPanel minutesTopPanel3 = new MinutesTopPanel(ElevenPosition.THIRD);
		MinutesTopPanel minutesTopPanel4 = new MinutesTopPanel(ElevenPosition.FOURTH);
		MinutesTopPanel minutesTopPanel5 = new MinutesTopPanel(ElevenPosition.FIFTH);
		MinutesTopPanel minutesTopPanel6 = new MinutesTopPanel(ElevenPosition.SIXTH);
		MinutesTopPanel minutesTopPanel7 = new MinutesTopPanel(ElevenPosition.SEVENTH);
		MinutesTopPanel minutesTopPanel8 = new MinutesTopPanel(ElevenPosition.EIGHT);
		MinutesTopPanel minutesTopPanel9 = new MinutesTopPanel(ElevenPosition.NINTH);
		MinutesTopPanel minutesTopPanel10 = new MinutesTopPanel(ElevenPosition.TENTH);
		MinutesTopPanel minutesTopPanel11 = new MinutesTopPanel(ElevenPosition.ELEVENTH);
		minutesTopPanels = new MinutesTopPanel[] { minutesTopPanel1, minutesTopPanel2, minutesTopPanel3, minutesTopPanel4, minutesTopPanel5,
				minutesTopPanel6, minutesTopPanel7, minutesTopPanel8, minutesTopPanel9, minutesTopPanel10, minutesTopPanel11 };
		
		MinutesBottomPanel minutesBottomPanel1 = new MinutesBottomPanel(FourPosition.FIRST);
		MinutesBottomPanel minutesBottomPanel2 = new MinutesBottomPanel(FourPosition.SECOND);
		MinutesBottomPanel minutesBottomPanel3 = new MinutesBottomPanel(FourPosition.THIRD);
		MinutesBottomPanel minutesBottomPanel4 = new MinutesBottomPanel(FourPosition.FOURTH);
		minutesBottomPanels = new MinutesBottomPanel[] { minutesBottomPanel1, minutesBottomPanel2, minutesBottomPanel3, minutesBottomPanel4 };

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(bottomHour1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(minutesTopPanel1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel3, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
								.addComponent(topHour1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
								.addComponent(minutesBottomPanel1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(topHour2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(bottomHour2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(topHour3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(bottomHour3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bottomHour4, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addComponent(topHour4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(minutesTopPanel4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(minutesTopPanel5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(minutesTopPanel6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(minutesTopPanel7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minutesTopPanel11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(minutesBottomPanel2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(minutesBottomPanel3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(minutesBottomPanel4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(131)
							.addComponent(secondsPanel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(secondsPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(topHour2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(topHour1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(topHour4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(topHour3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(bottomHour4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bottomHour3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bottomHour2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bottomHour1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(minutesTopPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(minutesTopPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(minutesTopPanel10, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(minutesTopPanel9, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(minutesTopPanel11, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(minutesBottomPanel2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(minutesBottomPanel1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(minutesBottomPanel3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(minutesBottomPanel4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		minutesTopPanel3.setLayout(new CardLayout(0, 0));

		return gl_contentPane;
	}
}
