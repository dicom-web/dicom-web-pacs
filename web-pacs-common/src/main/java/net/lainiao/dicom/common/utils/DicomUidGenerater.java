package net.lainiao.dicom.common.utils;

import java.rmi.server.UID;



public class DicomUidGenerater {

	private static final int EXPECT_DOT = 0;
	private static final int EXPECT_FIRST_DIGIT = 1;
	private static final int EXPECT_DOT_OR_DIGIT = 2;
	private static final int ILLEGAL_UID = -1;

	public static final String UUID_ROOT = "1.3.6.1.4.1.21308";
	public static final String UUID_DESCRIPTIVE ="11.25.2";
	public static final String UUID_TYPE_ID = "2";
	
	private static String root = UUID_ROOT;
	private static String descriptive = UUID_DESCRIPTIVE;
	private static String type_id = UUID_TYPE_ID;

	private static boolean acceptLeadingZero = false;

	/**
	 * 返回是否允许以0开头
	 * 
	 * @return
	 */
	public static final boolean isAcceptLeadingZero() {
		return acceptLeadingZero;
	}

	/**
	 * 设置是否允许以0作为组件开头
	 * 
	 * @param acceptLeadingZero
	 *            ：false不允许
	 */
	public static final void setAcceptLeadingZero(boolean acceptLeadingZero) {
		DicomUidGenerater.acceptLeadingZero = acceptLeadingZero;
	}

	/**
	 * 设置根< org.root >
	 * 
	 * @param root
	 */
	public static void setRoot(String root) {
		verifyUIDRoot(root);
		DicomUidGenerater.root = root;
	}
	/**
	 * 设置描述组件，
	 * @param descriptive 格式：< application id >.< object id >.< UID type id > 
	 * @example 11.22.2 其中11代表当前应用自定义编码为11，22代表当前对象自定义编码为22， 2代表当前UID类型为2，我们设置2为series instance uid
	 *  3 为study instance uid ，4 为SOP instance UID
	 */
	public static void setDescriptive(String descriptive){
		DicomUidGenerater.descriptive = descriptive;
	}
	/**
	 * 
	 * @param typeID 我们设置2为series instance uid
	 *  3 为study instance uid ，4 为SOP instance UID
	 */
	public static void setTypeID(String typeID){
		DicomUidGenerater.type_id = typeID;
	}

	private static void verifyUIDRoot(String root) {
		if (root.length() > 24) {
			throw new IllegalArgumentException("root length > 24");
		}
		verifyUID(root);
	}

	/**
	 * 获取根
	 * 
	 * @return
	 */
	public static String getRoot() {
		return root;
	}

	/**
	 * 验证UID是否满足要求
	 * 
	 * @param uid
	 */
	public static void verifyUID(String uid) {
		verifyUID(uid, acceptLeadingZero);
	}

	/**
	 * 验证UID是否满足要求
	 * 
	 * @param uid
	 * @param acceptLeadingZero
	 *            能否以O开始组件
	 */
	public static void verifyUID(String uid, boolean acceptLeadingZero) {
		if (!isValidUID(uid, acceptLeadingZero)) {
			throw new IllegalArgumentException(uid);
		}
	}

	public static boolean isValidUID(String uid) {
		return isValidUID(uid, acceptLeadingZero);
	}

	/**
	 * 验证UID是否合法
	 * 
	 * @param uid
	 * @param acceptLeadingZero
	 * @return 返回
	 */
	public static boolean isValidUID(String uid, boolean acceptLeadingZero) {
		int len = uid.length();
		if (len > 64) {
			return false;
		}

		int state = EXPECT_FIRST_DIGIT;
		for (int i = 0; i < len; i++) {
			state = nextState(state, uid.charAt(i), acceptLeadingZero);
			if (state == ILLEGAL_UID) {
				return false;
			}
		}
		return state != EXPECT_FIRST_DIGIT;
	}

	private static int nextState(int state, int ch, boolean acceptLeadingZero) {
		return ch == '.' ? (state == EXPECT_FIRST_DIGIT ? ILLEGAL_UID
				: EXPECT_FIRST_DIGIT)
				: (state == EXPECT_DOT || ch < '0' || ch > '9') ? ILLEGAL_UID
						: !acceptLeadingZero && state == EXPECT_FIRST_DIGIT
								&& ch == '0' ? EXPECT_DOT : EXPECT_DOT_OR_DIGIT;
	}
	/**
	 * 不带参数创建UID
	 * @return 创建好的UID
	 */
	public static String createUID() {
		return doCreateUID(root,descriptive,type_id);
	}
	/**
	 * 带参数创建UID
	 * @param root 根
	 * @param descriptive 描述
	 * @param type_id 类型 我们设置2为series instance uid
	 *  3 为study instance uid ，4 为SOP instance UID
	 * @return 创建好的UID
	 */
	public static String createUID(String root,String descriptive ,String type_id) {
		verifyUIDRoot(root);
		return doCreateUID(root,descriptive,type_id);
	}
	/**
	 * 
	 * @param root
	 * @param descriptive
	 * @param type_id
	 * @return
	 */
	private static String doCreateUID(String root,String descriptive ,String type_id) {
		StringBuffer UIDs =  new StringBuffer();
		UIDs.append(root).append(".");
		UIDs.append(descriptive).append(".");
		UID uid = new UID();
		String uniqueness = uid.toString();
		String[] uniquenessArr = uniqueness.split(":");
		int unique =Integer.parseInt(uniquenessArr[0],16);
		long time = Long.parseLong(uniquenessArr[1],16);
		int count = Integer.parseInt(uniquenessArr[2],16);
		unique = 0x000000FFFF & unique;
		count = 0x000000FFFF & count;
		UIDs.append(unique).append(".");
		UIDs.append(time).append(".");
		UIDs.append(count).append(".");
		UIDs.append(type_id);	
		return UIDs.toString();
	}

	/**
	 * 2 序列
	 * 3 检查
	 * 4 instance
	 *
	 * **/
	public static String getIUID(String type){
		String seriesInstanceUIDEach = DicomUidGenerater.createUID(
				"1.3.6.1.4.1.21308", "4.24.2", type);
		return seriesInstanceUIDEach;
	}

}
