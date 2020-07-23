package net.lainiao.dicom.scp.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class Series implements Serializable {

    private static final long serialVersionUID = 1595321575411L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:1
    */
    private Integer studyId;

    /**
    * 
    * isNullAble:1
    */
    private String seriesUid;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setStudyId(Integer studyId){this.studyId = studyId;}

    public Integer getStudyId(){return this.studyId;}

    public void setSeriesUid(String seriesUid){this.seriesUid = seriesUid;}

    public String getSeriesUid(){return this.seriesUid;}
    @Override
    public String toString() {
        return "Series{" +
                "id='" + id + '\'' +
                "studyId='" + studyId + '\'' +
                "seriesUid='" + seriesUid + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Series set;

        private ConditionBuilder where;

        public UpdateBuilder set(Series set){
            this.set = set;
            return this;
        }

        public Series getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends Series{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> studyIdList;

        public List<Integer> getStudyIdList(){return this.studyIdList;}

        private Integer studyIdSt;

        private Integer studyIdEd;

        public Integer getStudyIdSt(){return this.studyIdSt;}

        public Integer getStudyIdEd(){return this.studyIdEd;}

        private List<String> seriesUidList;

        public List<String> getSeriesUidList(){return this.seriesUidList;}


        private List<String> fuzzySeriesUid;

        public List<String> getFuzzySeriesUid(){return this.fuzzySeriesUid;}

        private List<String> rightFuzzySeriesUid;

        public List<String> getRightFuzzySeriesUid(){return this.rightFuzzySeriesUid;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder studyIdBetWeen(Integer studyIdSt,Integer studyIdEd){
            this.studyIdSt = studyIdSt;
            this.studyIdEd = studyIdEd;
            return this;
        }

        public QueryBuilder studyIdGreaterEqThan(Integer studyIdSt){
            this.studyIdSt = studyIdSt;
            return this;
        }
        public QueryBuilder studyIdLessEqThan(Integer studyIdEd){
            this.studyIdEd = studyIdEd;
            return this;
        }


        public QueryBuilder studyId(Integer studyId){
            setStudyId(studyId);
            return this;
        }

        public QueryBuilder studyIdList(Integer ... studyId){
            this.studyIdList = solveNullList(studyId);
            return this;
        }

        public QueryBuilder studyIdList(List<Integer> studyId){
            this.studyIdList = studyId;
            return this;
        }

        public QueryBuilder fetchStudyId(){
            setFetchFields("fetchFields","studyId");
            return this;
        }

        public QueryBuilder excludeStudyId(){
            setFetchFields("excludeFields","studyId");
            return this;
        }

        public QueryBuilder fuzzySeriesUid (List<String> fuzzySeriesUid){
            this.fuzzySeriesUid = fuzzySeriesUid;
            return this;
        }

        public QueryBuilder fuzzySeriesUid (String ... fuzzySeriesUid){
            this.fuzzySeriesUid = solveNullList(fuzzySeriesUid);
            return this;
        }

        public QueryBuilder rightFuzzySeriesUid (List<String> rightFuzzySeriesUid){
            this.rightFuzzySeriesUid = rightFuzzySeriesUid;
            return this;
        }

        public QueryBuilder rightFuzzySeriesUid (String ... rightFuzzySeriesUid){
            this.rightFuzzySeriesUid = solveNullList(rightFuzzySeriesUid);
            return this;
        }

        public QueryBuilder seriesUid(String seriesUid){
            setSeriesUid(seriesUid);
            return this;
        }

        public QueryBuilder seriesUidList(String ... seriesUid){
            this.seriesUidList = solveNullList(seriesUid);
            return this;
        }

        public QueryBuilder seriesUidList(List<String> seriesUid){
            this.seriesUidList = seriesUid;
            return this;
        }

        public QueryBuilder fetchSeriesUid(){
            setFetchFields("fetchFields","seriesUid");
            return this;
        }

        public QueryBuilder excludeSeriesUid(){
            setFetchFields("excludeFields","seriesUid");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public Series build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> studyIdList;

        public List<Integer> getStudyIdList(){return this.studyIdList;}

        private Integer studyIdSt;

        private Integer studyIdEd;

        public Integer getStudyIdSt(){return this.studyIdSt;}

        public Integer getStudyIdEd(){return this.studyIdEd;}

        private List<String> seriesUidList;

        public List<String> getSeriesUidList(){return this.seriesUidList;}


        private List<String> fuzzySeriesUid;

        public List<String> getFuzzySeriesUid(){return this.fuzzySeriesUid;}

        private List<String> rightFuzzySeriesUid;

        public List<String> getRightFuzzySeriesUid(){return this.rightFuzzySeriesUid;}

        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder studyIdBetWeen(Integer studyIdSt,Integer studyIdEd){
            this.studyIdSt = studyIdSt;
            this.studyIdEd = studyIdEd;
            return this;
        }

        public ConditionBuilder studyIdGreaterEqThan(Integer studyIdSt){
            this.studyIdSt = studyIdSt;
            return this;
        }
        public ConditionBuilder studyIdLessEqThan(Integer studyIdEd){
            this.studyIdEd = studyIdEd;
            return this;
        }


        public ConditionBuilder studyIdList(Integer ... studyId){
            this.studyIdList = solveNullList(studyId);
            return this;
        }

        public ConditionBuilder studyIdList(List<Integer> studyId){
            this.studyIdList = studyId;
            return this;
        }

        public ConditionBuilder fuzzySeriesUid (List<String> fuzzySeriesUid){
            this.fuzzySeriesUid = fuzzySeriesUid;
            return this;
        }

        public ConditionBuilder fuzzySeriesUid (String ... fuzzySeriesUid){
            this.fuzzySeriesUid = solveNullList(fuzzySeriesUid);
            return this;
        }

        public ConditionBuilder rightFuzzySeriesUid (List<String> rightFuzzySeriesUid){
            this.rightFuzzySeriesUid = rightFuzzySeriesUid;
            return this;
        }

        public ConditionBuilder rightFuzzySeriesUid (String ... rightFuzzySeriesUid){
            this.rightFuzzySeriesUid = solveNullList(rightFuzzySeriesUid);
            return this;
        }

        public ConditionBuilder seriesUidList(String ... seriesUid){
            this.seriesUidList = solveNullList(seriesUid);
            return this;
        }

        public ConditionBuilder seriesUidList(List<String> seriesUid){
            this.seriesUidList = seriesUid;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private Series obj;

        public Builder(){
            this.obj = new Series();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder studyId(Integer studyId){
            this.obj.setStudyId(studyId);
            return this;
        }
        public Builder seriesUid(String seriesUid){
            this.obj.setSeriesUid(seriesUid);
            return this;
        }
        public Series build(){return obj;}
    }

}
