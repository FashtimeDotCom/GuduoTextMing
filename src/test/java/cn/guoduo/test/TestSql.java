package cn.guoduo.test;

import com.hankcs.hanlp.dictionary.py.Integer2PinyinConverter;

/**
 * @athor Lijian
 * @date 2016年05月13日
 */
public class TestSql {
    public static void main(String[] args) {
        String path = TestSql.class.getClassLoader().getResource("/").getPath();
        System.out.println(path);
        Integer[] set = new Integer[]{1,2,3,4,5,6,7};
        StringBuilder sb = new StringBuilder();
        sb.append("select content ");
        sb.append("from video_comments ");
        sb.append("where sub_vid in (");
        int batchReloadedSize =0;
        for (Integer integer : set) {
            if(batchReloadedSize > 0) {
                sb.append(',');
            }
            sb.append(integer);
            ++batchReloadedSize;
        }
        sb.append(")");
        sb.append("and content like ");
        int likeSize =0;
        String[] likes = new String[]{"ddd","dsdsds"};
        for (String like : likes) {
            if(likeSize > 0) {
                sb.append("or content like");
            }
            sb.append("'%" + like +"%'");
            ++likeSize;
        }
        System.out.println(sb.toString());
    }
}
