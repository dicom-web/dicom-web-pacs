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
public class Instance implements Serializable {

    private static final long serialVersionUID = 1595321565156L;


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
    private Integer seriesId;

    /**
    * 
    * isNullAble:1
    */
    private String instanceUid;

    /**
    * 
    * isNullAble:1
    */
    private Integer instanceNum;

    /**
    * 
    * isNullAble:1
    */
    private String objectName;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setSeriesId(Integer seriesId){this.seriesId = seriesId;}

    public Integer getSeriesId(){return this.seriesId;}

    public void setInstanceUid(String instanceUid){this.instanceUid = instanceUid;}

    public String getInstanceUid(){return this.instanceUid;}

    public void setInstanceNum(Integer instanceNum){this.instanceNum = instanceNum;}

    public Integer getInstanceNum(){return this.instanceNum;}

    public void setObjectName(String objectName){this.objectName = objectName;}

    public String getObjectName(){return this.objectName;}
    @Override
    public String toString() {
        return "Instance{" +
                "id='" + id + '\'' +
                "seriesId='" + seriesId + '\'' +
                "instanceUid='" + instanceUid + '\'' +
                "instanceNum='" + instanceNum + '\'' +
                "objectName='" + objectName + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Instance set;

        private ConditionBuilder where;

        public UpdateBuilder set(Instance set){
            this.set = set;
            return this;
        }

        public Instance getSet(){
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

    public static class QueryBuilder extends Instance{
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

        private List<Integer> seriesIdList;

        public List<Integer> getSeriesIdList(){return this.seriesIdList;}

        private Integer seriesIdSt;

        private Integer seriesIdEd;

        public Integer getSeriesIdSt(){return this.seriesIdSt;}

        public Integer getSeriesIdEd(){return this.seriesIdEd;}

        private List<String> instanceUidList;

        public List<String> getInstanceUidList(){return this.instanceUidList;}


        private List<String> fuzzyInstanceUid;

        public List<String> getFuzzyInstanceUid(){return this.fuzzyInstanceUid;}

        private List<String> rightFuzzyInstanceUid;

        public List<String> getRightFuzzyInstanceUid(){return this.rightFuzzyInstanceUid;}
        private List<Integer> instanceNumList;

        public List<Integer> getInstanceNumList(){return this.instanceNumList;}

        private Integer instanceNumSt;

        private Integer instanceNumEd;

        public Integer getInstanceNumSt(){return this.instanceNumSt;}

        public Integer getInstanceNumEd(){return this.instanceNumEd;}

        private List<String> objectNameList;

        public List<String> getObjectNameList(){return this.objectNameList;}


        private List<String> fuzzyObjectName;

        public List<String> getFuzzyObjectName(){return this.fuzzyObjectName;}

        private List<String> rightFuzzyObjectName;

        public List<String> getRightFuzzyObjectName(){return this.rightFuzzyObjectName;}
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

        public QueryBuilder seriesIdBetWeen(Integer seriesIdSt,Integer seriesIdEd){
            this.seriesIdSt = seriesIdSt;
            this.seriesIdEd = seriesIdEd;
            return this;
        }

        public QueryBuilder seriesIdGreaterEqThan(Integer seriesIdSt){
            this.seriesIdSt = seriesIdSt;
            return this;
        }
        public QueryBuilder seriesIdLessEqThan(Integer seriesIdEd){
            this.seriesIdEd = seriesIdEd;
            return this;
        }


        public QueryBuilder seriesId(Integer seriesId){
            setSeriesId(seriesId);
            return this;
        }

        public QueryBuilder seriesIdList(Integer ... seriesId){
            this.seriesIdList = solveNullList(seriesId);
            return this;
        }

        public QueryBuilder seriesIdList(List<Integer> seriesId){
            this.seriesIdList = seriesId;
            return this;
        }

        public QueryBuilder fetchSeriesId(){
            setFetchFields("fetchFields","seriesId");
            return this;
        }

        public QueryBuilder excludeSeriesId(){
            setFetchFields("excludeFields","seriesId");
            return this;
        }

        public QueryBuilder fuzzyInstanceUid (List<String> fuzzyInstanceUid){
            this.fuzzyInstanceUid = fuzzyInstanceUid;
            return this;
        }

        public QueryBuilder fuzzyInstanceUid (String ... fuzzyInstanceUid){
            this.fuzzyInstanceUid = solveNullList(fuzzyInstanceUid);
            return this;
        }

        public QueryBuilder rightFuzzyInstanceUid (List<String> rightFuzzyInstanceUid){
            this.rightFuzzyInstanceUid = rightFuzzyInstanceUid;
            return this;
        }

        public QueryBuilder rightFuzzyInstanceUid (String ... rightFuzzyInstanceUid){
            this.rightFuzzyInstanceUid = solveNullList(rightFuzzyInstanceUid);
            return this;
        }

        public QueryBuilder instanceUid(String instanceUid){
            setInstanceUid(instanceUid);
            return this;
        }

        public QueryBuilder instanceUidList(String ... instanceUid){
            this.instanceUidList = solveNullList(instanceUid);
            return this;
        }

        public QueryBuilder instanceUidList(List<String> instanceUid){
            this.instanceUidList = instanceUid;
            return this;
        }

        public QueryBuilder fetchInstanceUid(){
            setFetchFields("fetchFields","instanceUid");
            return this;
        }

        public QueryBuilder excludeInstanceUid(){
            setFetchFields("excludeFields","instanceUid");
            return this;
        }

        public QueryBuilder instanceNumBetWeen(Integer instanceNumSt,Integer instanceNumEd){
            this.instanceNumSt = instanceNumSt;
            this.instanceNumEd = instanceNumEd;
            return this;
        }

        public QueryBuilder instanceNumGreaterEqThan(Integer instanceNumSt){
            this.instanceNumSt = instanceNumSt;
            return this;
        }
        public QueryBuilder instanceNumLessEqThan(Integer instanceNumEd){
            this.instanceNumEd = instanceNumEd;
            return this;
        }


        public QueryBuilder instanceNum(Integer instanceNum){
            setInstanceNum(instanceNum);
            return this;
        }

        public QueryBuilder instanceNumList(Integer ... instanceNum){
            this.instanceNumList = solveNullList(instanceNum);
            return this;
        }

        public QueryBuilder instanceNumList(List<Integer> instanceNum){
            this.instanceNumList = instanceNum;
            return this;
        }

        public QueryBuilder fetchInstanceNum(){
            setFetchFields("fetchFields","instanceNum");
            return this;
        }

        public QueryBuilder excludeInstanceNum(){
            setFetchFields("excludeFields","instanceNum");
            return this;
        }

        public QueryBuilder fuzzyObjectName (List<String> fuzzyObjectName){
            this.fuzzyObjectName = fuzzyObjectName;
            return this;
        }

        public QueryBuilder fuzzyObjectName (String ... fuzzyObjectName){
            this.fuzzyObjectName = solveNullList(fuzzyObjectName);
            return this;
        }

        public QueryBuilder rightFuzzyObjectName (List<String> rightFuzzyObjectName){
            this.rightFuzzyObjectName = rightFuzzyObjectName;
            return this;
        }

        public QueryBuilder rightFuzzyObjectName (String ... rightFuzzyObjectName){
            this.rightFuzzyObjectName = solveNullList(rightFuzzyObjectName);
            return this;
        }

        public QueryBuilder objectName(String objectName){
            setObjectName(objectName);
            return this;
        }

        public QueryBuilder objectNameList(String ... objectName){
            this.objectNameList = solveNullList(objectName);
            return this;
        }

        public QueryBuilder objectNameList(List<String> objectName){
            this.objectNameList = objectName;
            return this;
        }

        public QueryBuilder fetchObjectName(){
            setFetchFields("fetchFields","objectName");
            return this;
        }

        public QueryBuilder excludeObjectName(){
            setFetchFields("excludeFields","objectName");
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

        public Instance build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> seriesIdList;

        public List<Integer> getSeriesIdList(){return this.seriesIdList;}

        private Integer seriesIdSt;

        private Integer seriesIdEd;

        public Integer getSeriesIdSt(){return this.seriesIdSt;}

        public Integer getSeriesIdEd(){return this.seriesIdEd;}

        private List<String> instanceUidList;

        public List<String> getInstanceUidList(){return this.instanceUidList;}


        private List<String> fuzzyInstanceUid;

        public List<String> getFuzzyInstanceUid(){return this.fuzzyInstanceUid;}

        private List<String> rightFuzzyInstanceUid;

        public List<String> getRightFuzzyInstanceUid(){return this.rightFuzzyInstanceUid;}
        private List<Integer> instanceNumList;

        public List<Integer> getInstanceNumList(){return this.instanceNumList;}

        private Integer instanceNumSt;

        private Integer instanceNumEd;

        public Integer getInstanceNumSt(){return this.instanceNumSt;}

        public Integer getInstanceNumEd(){return this.instanceNumEd;}

        private List<String> objectNameList;

        public List<String> getObjectNameList(){return this.objectNameList;}


        private List<String> fuzzyObjectName;

        public List<String> getFuzzyObjectName(){return this.fuzzyObjectName;}

        private List<String> rightFuzzyObjectName;

        public List<String> getRightFuzzyObjectName(){return this.rightFuzzyObjectName;}

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

        public ConditionBuilder seriesIdBetWeen(Integer seriesIdSt,Integer seriesIdEd){
            this.seriesIdSt = seriesIdSt;
            this.seriesIdEd = seriesIdEd;
            return this;
        }

        public ConditionBuilder seriesIdGreaterEqThan(Integer seriesIdSt){
            this.seriesIdSt = seriesIdSt;
            return this;
        }
        public ConditionBuilder seriesIdLessEqThan(Integer seriesIdEd){
            this.seriesIdEd = seriesIdEd;
            return this;
        }


        public ConditionBuilder seriesIdList(Integer ... seriesId){
            this.seriesIdList = solveNullList(seriesId);
            return this;
        }

        public ConditionBuilder seriesIdList(List<Integer> seriesId){
            this.seriesIdList = seriesId;
            return this;
        }

        public ConditionBuilder fuzzyInstanceUid (List<String> fuzzyInstanceUid){
            this.fuzzyInstanceUid = fuzzyInstanceUid;
            return this;
        }

        public ConditionBuilder fuzzyInstanceUid (String ... fuzzyInstanceUid){
            this.fuzzyInstanceUid = solveNullList(fuzzyInstanceUid);
            return this;
        }

        public ConditionBuilder rightFuzzyInstanceUid (List<String> rightFuzzyInstanceUid){
            this.rightFuzzyInstanceUid = rightFuzzyInstanceUid;
            return this;
        }

        public ConditionBuilder rightFuzzyInstanceUid (String ... rightFuzzyInstanceUid){
            this.rightFuzzyInstanceUid = solveNullList(rightFuzzyInstanceUid);
            return this;
        }

        public ConditionBuilder instanceUidList(String ... instanceUid){
            this.instanceUidList = solveNullList(instanceUid);
            return this;
        }

        public ConditionBuilder instanceUidList(List<String> instanceUid){
            this.instanceUidList = instanceUid;
            return this;
        }

        public ConditionBuilder instanceNumBetWeen(Integer instanceNumSt,Integer instanceNumEd){
            this.instanceNumSt = instanceNumSt;
            this.instanceNumEd = instanceNumEd;
            return this;
        }

        public ConditionBuilder instanceNumGreaterEqThan(Integer instanceNumSt){
            this.instanceNumSt = instanceNumSt;
            return this;
        }
        public ConditionBuilder instanceNumLessEqThan(Integer instanceNumEd){
            this.instanceNumEd = instanceNumEd;
            return this;
        }


        public ConditionBuilder instanceNumList(Integer ... instanceNum){
            this.instanceNumList = solveNullList(instanceNum);
            return this;
        }

        public ConditionBuilder instanceNumList(List<Integer> instanceNum){
            this.instanceNumList = instanceNum;
            return this;
        }

        public ConditionBuilder fuzzyObjectName (List<String> fuzzyObjectName){
            this.fuzzyObjectName = fuzzyObjectName;
            return this;
        }

        public ConditionBuilder fuzzyObjectName (String ... fuzzyObjectName){
            this.fuzzyObjectName = solveNullList(fuzzyObjectName);
            return this;
        }

        public ConditionBuilder rightFuzzyObjectName (List<String> rightFuzzyObjectName){
            this.rightFuzzyObjectName = rightFuzzyObjectName;
            return this;
        }

        public ConditionBuilder rightFuzzyObjectName (String ... rightFuzzyObjectName){
            this.rightFuzzyObjectName = solveNullList(rightFuzzyObjectName);
            return this;
        }

        public ConditionBuilder objectNameList(String ... objectName){
            this.objectNameList = solveNullList(objectName);
            return this;
        }

        public ConditionBuilder objectNameList(List<String> objectName){
            this.objectNameList = objectName;
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

        private Instance obj;

        public Builder(){
            this.obj = new Instance();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder seriesId(Integer seriesId){
            this.obj.setSeriesId(seriesId);
            return this;
        }
        public Builder instanceUid(String instanceUid){
            this.obj.setInstanceUid(instanceUid);
            return this;
        }
        public Builder instanceNum(Integer instanceNum){
            this.obj.setInstanceNum(instanceNum);
            return this;
        }
        public Builder objectName(String objectName){
            this.obj.setObjectName(objectName);
            return this;
        }
        public Instance build(){return obj;}
    }

}
