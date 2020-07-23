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
public class Study implements Serializable {

    private static final long serialVersionUID = 1595321580312L;


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
    private Integer patId;

    /**
    * 
    * isNullAble:1
    */
    private String studyUid;

    /**
    * 
    * isNullAble:1
    */
    private String modality;

    /**
    * 
    * isNullAble:1
    */
    private String accessionNo;

    /**
    * 
    * isNullAble:1
    */
    private String studyDate;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setPatId(Integer patId){this.patId = patId;}

    public Integer getPatId(){return this.patId;}

    public void setStudyUid(String studyUid){this.studyUid = studyUid;}

    public String getStudyUid(){return this.studyUid;}

    public void setModality(String modality){this.modality = modality;}

    public String getModality(){return this.modality;}

    public void setAccessionNo(String accessionNo){this.accessionNo = accessionNo;}

    public String getAccessionNo(){return this.accessionNo;}

    public void setStudyDate(String studyDate){this.studyDate = studyDate;}

    public String getStudyDate(){return this.studyDate;}
    @Override
    public String toString() {
        return "Study{" +
                "id='" + id + '\'' +
                "patId='" + patId + '\'' +
                "studyUid='" + studyUid + '\'' +
                "modality='" + modality + '\'' +
                "accessionNo='" + accessionNo + '\'' +
                "studyDate='" + studyDate + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Study set;

        private ConditionBuilder where;

        public UpdateBuilder set(Study set){
            this.set = set;
            return this;
        }

        public Study getSet(){
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

    public static class QueryBuilder extends Study{
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

        private List<Integer> patIdList;

        public List<Integer> getPatIdList(){return this.patIdList;}

        private Integer patIdSt;

        private Integer patIdEd;

        public Integer getPatIdSt(){return this.patIdSt;}

        public Integer getPatIdEd(){return this.patIdEd;}

        private List<String> studyUidList;

        public List<String> getStudyUidList(){return this.studyUidList;}


        private List<String> fuzzyStudyUid;

        public List<String> getFuzzyStudyUid(){return this.fuzzyStudyUid;}

        private List<String> rightFuzzyStudyUid;

        public List<String> getRightFuzzyStudyUid(){return this.rightFuzzyStudyUid;}
        private List<String> modalityList;

        public List<String> getModalityList(){return this.modalityList;}


        private List<String> fuzzyModality;

        public List<String> getFuzzyModality(){return this.fuzzyModality;}

        private List<String> rightFuzzyModality;

        public List<String> getRightFuzzyModality(){return this.rightFuzzyModality;}
        private List<String> accessionNoList;

        public List<String> getAccessionNoList(){return this.accessionNoList;}


        private List<String> fuzzyAccessionNo;

        public List<String> getFuzzyAccessionNo(){return this.fuzzyAccessionNo;}

        private List<String> rightFuzzyAccessionNo;

        public List<String> getRightFuzzyAccessionNo(){return this.rightFuzzyAccessionNo;}
        private List<String> studyDateList;

        public List<String> getStudyDateList(){return this.studyDateList;}


        private List<String> fuzzyStudyDate;

        public List<String> getFuzzyStudyDate(){return this.fuzzyStudyDate;}

        private List<String> rightFuzzyStudyDate;

        public List<String> getRightFuzzyStudyDate(){return this.rightFuzzyStudyDate;}
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

        public QueryBuilder patIdBetWeen(Integer patIdSt,Integer patIdEd){
            this.patIdSt = patIdSt;
            this.patIdEd = patIdEd;
            return this;
        }

        public QueryBuilder patIdGreaterEqThan(Integer patIdSt){
            this.patIdSt = patIdSt;
            return this;
        }
        public QueryBuilder patIdLessEqThan(Integer patIdEd){
            this.patIdEd = patIdEd;
            return this;
        }


        public QueryBuilder patId(Integer patId){
            setPatId(patId);
            return this;
        }

        public QueryBuilder patIdList(Integer ... patId){
            this.patIdList = solveNullList(patId);
            return this;
        }

        public QueryBuilder patIdList(List<Integer> patId){
            this.patIdList = patId;
            return this;
        }

        public QueryBuilder fetchPatId(){
            setFetchFields("fetchFields","patId");
            return this;
        }

        public QueryBuilder excludePatId(){
            setFetchFields("excludeFields","patId");
            return this;
        }

        public QueryBuilder fuzzyStudyUid (List<String> fuzzyStudyUid){
            this.fuzzyStudyUid = fuzzyStudyUid;
            return this;
        }

        public QueryBuilder fuzzyStudyUid (String ... fuzzyStudyUid){
            this.fuzzyStudyUid = solveNullList(fuzzyStudyUid);
            return this;
        }

        public QueryBuilder rightFuzzyStudyUid (List<String> rightFuzzyStudyUid){
            this.rightFuzzyStudyUid = rightFuzzyStudyUid;
            return this;
        }

        public QueryBuilder rightFuzzyStudyUid (String ... rightFuzzyStudyUid){
            this.rightFuzzyStudyUid = solveNullList(rightFuzzyStudyUid);
            return this;
        }

        public QueryBuilder studyUid(String studyUid){
            setStudyUid(studyUid);
            return this;
        }

        public QueryBuilder studyUidList(String ... studyUid){
            this.studyUidList = solveNullList(studyUid);
            return this;
        }

        public QueryBuilder studyUidList(List<String> studyUid){
            this.studyUidList = studyUid;
            return this;
        }

        public QueryBuilder fetchStudyUid(){
            setFetchFields("fetchFields","studyUid");
            return this;
        }

        public QueryBuilder excludeStudyUid(){
            setFetchFields("excludeFields","studyUid");
            return this;
        }

        public QueryBuilder fuzzyModality (List<String> fuzzyModality){
            this.fuzzyModality = fuzzyModality;
            return this;
        }

        public QueryBuilder fuzzyModality (String ... fuzzyModality){
            this.fuzzyModality = solveNullList(fuzzyModality);
            return this;
        }

        public QueryBuilder rightFuzzyModality (List<String> rightFuzzyModality){
            this.rightFuzzyModality = rightFuzzyModality;
            return this;
        }

        public QueryBuilder rightFuzzyModality (String ... rightFuzzyModality){
            this.rightFuzzyModality = solveNullList(rightFuzzyModality);
            return this;
        }

        public QueryBuilder modality(String modality){
            setModality(modality);
            return this;
        }

        public QueryBuilder modalityList(String ... modality){
            this.modalityList = solveNullList(modality);
            return this;
        }

        public QueryBuilder modalityList(List<String> modality){
            this.modalityList = modality;
            return this;
        }

        public QueryBuilder fetchModality(){
            setFetchFields("fetchFields","modality");
            return this;
        }

        public QueryBuilder excludeModality(){
            setFetchFields("excludeFields","modality");
            return this;
        }

        public QueryBuilder fuzzyAccessionNo (List<String> fuzzyAccessionNo){
            this.fuzzyAccessionNo = fuzzyAccessionNo;
            return this;
        }

        public QueryBuilder fuzzyAccessionNo (String ... fuzzyAccessionNo){
            this.fuzzyAccessionNo = solveNullList(fuzzyAccessionNo);
            return this;
        }

        public QueryBuilder rightFuzzyAccessionNo (List<String> rightFuzzyAccessionNo){
            this.rightFuzzyAccessionNo = rightFuzzyAccessionNo;
            return this;
        }

        public QueryBuilder rightFuzzyAccessionNo (String ... rightFuzzyAccessionNo){
            this.rightFuzzyAccessionNo = solveNullList(rightFuzzyAccessionNo);
            return this;
        }

        public QueryBuilder accessionNo(String accessionNo){
            setAccessionNo(accessionNo);
            return this;
        }

        public QueryBuilder accessionNoList(String ... accessionNo){
            this.accessionNoList = solveNullList(accessionNo);
            return this;
        }

        public QueryBuilder accessionNoList(List<String> accessionNo){
            this.accessionNoList = accessionNo;
            return this;
        }

        public QueryBuilder fetchAccessionNo(){
            setFetchFields("fetchFields","accessionNo");
            return this;
        }

        public QueryBuilder excludeAccessionNo(){
            setFetchFields("excludeFields","accessionNo");
            return this;
        }

        public QueryBuilder fuzzyStudyDate (List<String> fuzzyStudyDate){
            this.fuzzyStudyDate = fuzzyStudyDate;
            return this;
        }

        public QueryBuilder fuzzyStudyDate (String ... fuzzyStudyDate){
            this.fuzzyStudyDate = solveNullList(fuzzyStudyDate);
            return this;
        }

        public QueryBuilder rightFuzzyStudyDate (List<String> rightFuzzyStudyDate){
            this.rightFuzzyStudyDate = rightFuzzyStudyDate;
            return this;
        }

        public QueryBuilder rightFuzzyStudyDate (String ... rightFuzzyStudyDate){
            this.rightFuzzyStudyDate = solveNullList(rightFuzzyStudyDate);
            return this;
        }

        public QueryBuilder studyDate(String studyDate){
            setStudyDate(studyDate);
            return this;
        }

        public QueryBuilder studyDateList(String ... studyDate){
            this.studyDateList = solveNullList(studyDate);
            return this;
        }

        public QueryBuilder studyDateList(List<String> studyDate){
            this.studyDateList = studyDate;
            return this;
        }

        public QueryBuilder fetchStudyDate(){
            setFetchFields("fetchFields","studyDate");
            return this;
        }

        public QueryBuilder excludeStudyDate(){
            setFetchFields("excludeFields","studyDate");
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

        public Study build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> patIdList;

        public List<Integer> getPatIdList(){return this.patIdList;}

        private Integer patIdSt;

        private Integer patIdEd;

        public Integer getPatIdSt(){return this.patIdSt;}

        public Integer getPatIdEd(){return this.patIdEd;}

        private List<String> studyUidList;

        public List<String> getStudyUidList(){return this.studyUidList;}


        private List<String> fuzzyStudyUid;

        public List<String> getFuzzyStudyUid(){return this.fuzzyStudyUid;}

        private List<String> rightFuzzyStudyUid;

        public List<String> getRightFuzzyStudyUid(){return this.rightFuzzyStudyUid;}
        private List<String> modalityList;

        public List<String> getModalityList(){return this.modalityList;}


        private List<String> fuzzyModality;

        public List<String> getFuzzyModality(){return this.fuzzyModality;}

        private List<String> rightFuzzyModality;

        public List<String> getRightFuzzyModality(){return this.rightFuzzyModality;}
        private List<String> accessionNoList;

        public List<String> getAccessionNoList(){return this.accessionNoList;}


        private List<String> fuzzyAccessionNo;

        public List<String> getFuzzyAccessionNo(){return this.fuzzyAccessionNo;}

        private List<String> rightFuzzyAccessionNo;

        public List<String> getRightFuzzyAccessionNo(){return this.rightFuzzyAccessionNo;}
        private List<String> studyDateList;

        public List<String> getStudyDateList(){return this.studyDateList;}


        private List<String> fuzzyStudyDate;

        public List<String> getFuzzyStudyDate(){return this.fuzzyStudyDate;}

        private List<String> rightFuzzyStudyDate;

        public List<String> getRightFuzzyStudyDate(){return this.rightFuzzyStudyDate;}

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

        public ConditionBuilder patIdBetWeen(Integer patIdSt,Integer patIdEd){
            this.patIdSt = patIdSt;
            this.patIdEd = patIdEd;
            return this;
        }

        public ConditionBuilder patIdGreaterEqThan(Integer patIdSt){
            this.patIdSt = patIdSt;
            return this;
        }
        public ConditionBuilder patIdLessEqThan(Integer patIdEd){
            this.patIdEd = patIdEd;
            return this;
        }


        public ConditionBuilder patIdList(Integer ... patId){
            this.patIdList = solveNullList(patId);
            return this;
        }

        public ConditionBuilder patIdList(List<Integer> patId){
            this.patIdList = patId;
            return this;
        }

        public ConditionBuilder fuzzyStudyUid (List<String> fuzzyStudyUid){
            this.fuzzyStudyUid = fuzzyStudyUid;
            return this;
        }

        public ConditionBuilder fuzzyStudyUid (String ... fuzzyStudyUid){
            this.fuzzyStudyUid = solveNullList(fuzzyStudyUid);
            return this;
        }

        public ConditionBuilder rightFuzzyStudyUid (List<String> rightFuzzyStudyUid){
            this.rightFuzzyStudyUid = rightFuzzyStudyUid;
            return this;
        }

        public ConditionBuilder rightFuzzyStudyUid (String ... rightFuzzyStudyUid){
            this.rightFuzzyStudyUid = solveNullList(rightFuzzyStudyUid);
            return this;
        }

        public ConditionBuilder studyUidList(String ... studyUid){
            this.studyUidList = solveNullList(studyUid);
            return this;
        }

        public ConditionBuilder studyUidList(List<String> studyUid){
            this.studyUidList = studyUid;
            return this;
        }

        public ConditionBuilder fuzzyModality (List<String> fuzzyModality){
            this.fuzzyModality = fuzzyModality;
            return this;
        }

        public ConditionBuilder fuzzyModality (String ... fuzzyModality){
            this.fuzzyModality = solveNullList(fuzzyModality);
            return this;
        }

        public ConditionBuilder rightFuzzyModality (List<String> rightFuzzyModality){
            this.rightFuzzyModality = rightFuzzyModality;
            return this;
        }

        public ConditionBuilder rightFuzzyModality (String ... rightFuzzyModality){
            this.rightFuzzyModality = solveNullList(rightFuzzyModality);
            return this;
        }

        public ConditionBuilder modalityList(String ... modality){
            this.modalityList = solveNullList(modality);
            return this;
        }

        public ConditionBuilder modalityList(List<String> modality){
            this.modalityList = modality;
            return this;
        }

        public ConditionBuilder fuzzyAccessionNo (List<String> fuzzyAccessionNo){
            this.fuzzyAccessionNo = fuzzyAccessionNo;
            return this;
        }

        public ConditionBuilder fuzzyAccessionNo (String ... fuzzyAccessionNo){
            this.fuzzyAccessionNo = solveNullList(fuzzyAccessionNo);
            return this;
        }

        public ConditionBuilder rightFuzzyAccessionNo (List<String> rightFuzzyAccessionNo){
            this.rightFuzzyAccessionNo = rightFuzzyAccessionNo;
            return this;
        }

        public ConditionBuilder rightFuzzyAccessionNo (String ... rightFuzzyAccessionNo){
            this.rightFuzzyAccessionNo = solveNullList(rightFuzzyAccessionNo);
            return this;
        }

        public ConditionBuilder accessionNoList(String ... accessionNo){
            this.accessionNoList = solveNullList(accessionNo);
            return this;
        }

        public ConditionBuilder accessionNoList(List<String> accessionNo){
            this.accessionNoList = accessionNo;
            return this;
        }

        public ConditionBuilder fuzzyStudyDate (List<String> fuzzyStudyDate){
            this.fuzzyStudyDate = fuzzyStudyDate;
            return this;
        }

        public ConditionBuilder fuzzyStudyDate (String ... fuzzyStudyDate){
            this.fuzzyStudyDate = solveNullList(fuzzyStudyDate);
            return this;
        }

        public ConditionBuilder rightFuzzyStudyDate (List<String> rightFuzzyStudyDate){
            this.rightFuzzyStudyDate = rightFuzzyStudyDate;
            return this;
        }

        public ConditionBuilder rightFuzzyStudyDate (String ... rightFuzzyStudyDate){
            this.rightFuzzyStudyDate = solveNullList(rightFuzzyStudyDate);
            return this;
        }

        public ConditionBuilder studyDateList(String ... studyDate){
            this.studyDateList = solveNullList(studyDate);
            return this;
        }

        public ConditionBuilder studyDateList(List<String> studyDate){
            this.studyDateList = studyDate;
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

        private Study obj;

        public Builder(){
            this.obj = new Study();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder patId(Integer patId){
            this.obj.setPatId(patId);
            return this;
        }
        public Builder studyUid(String studyUid){
            this.obj.setStudyUid(studyUid);
            return this;
        }
        public Builder modality(String modality){
            this.obj.setModality(modality);
            return this;
        }
        public Builder accessionNo(String accessionNo){
            this.obj.setAccessionNo(accessionNo);
            return this;
        }
        public Builder studyDate(String studyDate){
            this.obj.setStudyDate(studyDate);
            return this;
        }
        public Study build(){return obj;}
    }

}
