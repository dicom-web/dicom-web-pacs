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
public class Patient implements Serializable {

    private static final long serialVersionUID = 1595321570915L;


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
    private String patName;

    /**
    * 
    * isNullAble:1
    */
    private String patNumber;

    /**
    * 
    * isNullAble:1
    */
    private String birthDay;

    /**
    * 
    * isNullAble:1
    */
    private String gender;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setPatName(String patName){this.patName = patName;}

    public String getPatName(){return this.patName;}

    public void setPatNumber(String patNumber){this.patNumber = patNumber;}

    public String getPatNumber(){return this.patNumber;}

    public void setBirthDay(String birthDay){this.birthDay = birthDay;}

    public String getBirthDay(){return this.birthDay;}

    public void setGender(String gender){this.gender = gender;}

    public String getGender(){return this.gender;}
    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                "patName='" + patName + '\'' +
                "patNumber='" + patNumber + '\'' +
                "birthDay='" + birthDay + '\'' +
                "gender='" + gender + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Patient set;

        private ConditionBuilder where;

        public UpdateBuilder set(Patient set){
            this.set = set;
            return this;
        }

        public Patient getSet(){
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

    public static class QueryBuilder extends Patient{
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

        private List<String> patNameList;

        public List<String> getPatNameList(){return this.patNameList;}


        private List<String> fuzzyPatName;

        public List<String> getFuzzyPatName(){return this.fuzzyPatName;}

        private List<String> rightFuzzyPatName;

        public List<String> getRightFuzzyPatName(){return this.rightFuzzyPatName;}
        private List<String> patNumberList;

        public List<String> getPatNumberList(){return this.patNumberList;}


        private List<String> fuzzyPatNumber;

        public List<String> getFuzzyPatNumber(){return this.fuzzyPatNumber;}

        private List<String> rightFuzzyPatNumber;

        public List<String> getRightFuzzyPatNumber(){return this.rightFuzzyPatNumber;}
        private List<String> birthDayList;

        public List<String> getBirthDayList(){return this.birthDayList;}


        private List<String> fuzzyBirthDay;

        public List<String> getFuzzyBirthDay(){return this.fuzzyBirthDay;}

        private List<String> rightFuzzyBirthDay;

        public List<String> getRightFuzzyBirthDay(){return this.rightFuzzyBirthDay;}
        private List<String> genderList;

        public List<String> getGenderList(){return this.genderList;}


        private List<String> fuzzyGender;

        public List<String> getFuzzyGender(){return this.fuzzyGender;}

        private List<String> rightFuzzyGender;

        public List<String> getRightFuzzyGender(){return this.rightFuzzyGender;}
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

        public QueryBuilder fuzzyPatName (List<String> fuzzyPatName){
            this.fuzzyPatName = fuzzyPatName;
            return this;
        }

        public QueryBuilder fuzzyPatName (String ... fuzzyPatName){
            this.fuzzyPatName = solveNullList(fuzzyPatName);
            return this;
        }

        public QueryBuilder rightFuzzyPatName (List<String> rightFuzzyPatName){
            this.rightFuzzyPatName = rightFuzzyPatName;
            return this;
        }

        public QueryBuilder rightFuzzyPatName (String ... rightFuzzyPatName){
            this.rightFuzzyPatName = solveNullList(rightFuzzyPatName);
            return this;
        }

        public QueryBuilder patName(String patName){
            setPatName(patName);
            return this;
        }

        public QueryBuilder patNameList(String ... patName){
            this.patNameList = solveNullList(patName);
            return this;
        }

        public QueryBuilder patNameList(List<String> patName){
            this.patNameList = patName;
            return this;
        }

        public QueryBuilder fetchPatName(){
            setFetchFields("fetchFields","patName");
            return this;
        }

        public QueryBuilder excludePatName(){
            setFetchFields("excludeFields","patName");
            return this;
        }

        public QueryBuilder fuzzyPatNumber (List<String> fuzzyPatNumber){
            this.fuzzyPatNumber = fuzzyPatNumber;
            return this;
        }

        public QueryBuilder fuzzyPatNumber (String ... fuzzyPatNumber){
            this.fuzzyPatNumber = solveNullList(fuzzyPatNumber);
            return this;
        }

        public QueryBuilder rightFuzzyPatNumber (List<String> rightFuzzyPatNumber){
            this.rightFuzzyPatNumber = rightFuzzyPatNumber;
            return this;
        }

        public QueryBuilder rightFuzzyPatNumber (String ... rightFuzzyPatNumber){
            this.rightFuzzyPatNumber = solveNullList(rightFuzzyPatNumber);
            return this;
        }

        public QueryBuilder patNumber(String patNumber){
            setPatNumber(patNumber);
            return this;
        }

        public QueryBuilder patNumberList(String ... patNumber){
            this.patNumberList = solveNullList(patNumber);
            return this;
        }

        public QueryBuilder patNumberList(List<String> patNumber){
            this.patNumberList = patNumber;
            return this;
        }

        public QueryBuilder fetchPatNumber(){
            setFetchFields("fetchFields","patNumber");
            return this;
        }

        public QueryBuilder excludePatNumber(){
            setFetchFields("excludeFields","patNumber");
            return this;
        }

        public QueryBuilder fuzzyBirthDay (List<String> fuzzyBirthDay){
            this.fuzzyBirthDay = fuzzyBirthDay;
            return this;
        }

        public QueryBuilder fuzzyBirthDay (String ... fuzzyBirthDay){
            this.fuzzyBirthDay = solveNullList(fuzzyBirthDay);
            return this;
        }

        public QueryBuilder rightFuzzyBirthDay (List<String> rightFuzzyBirthDay){
            this.rightFuzzyBirthDay = rightFuzzyBirthDay;
            return this;
        }

        public QueryBuilder rightFuzzyBirthDay (String ... rightFuzzyBirthDay){
            this.rightFuzzyBirthDay = solveNullList(rightFuzzyBirthDay);
            return this;
        }

        public QueryBuilder birthDay(String birthDay){
            setBirthDay(birthDay);
            return this;
        }

        public QueryBuilder birthDayList(String ... birthDay){
            this.birthDayList = solveNullList(birthDay);
            return this;
        }

        public QueryBuilder birthDayList(List<String> birthDay){
            this.birthDayList = birthDay;
            return this;
        }

        public QueryBuilder fetchBirthDay(){
            setFetchFields("fetchFields","birthDay");
            return this;
        }

        public QueryBuilder excludeBirthDay(){
            setFetchFields("excludeFields","birthDay");
            return this;
        }

        public QueryBuilder fuzzyGender (List<String> fuzzyGender){
            this.fuzzyGender = fuzzyGender;
            return this;
        }

        public QueryBuilder fuzzyGender (String ... fuzzyGender){
            this.fuzzyGender = solveNullList(fuzzyGender);
            return this;
        }

        public QueryBuilder rightFuzzyGender (List<String> rightFuzzyGender){
            this.rightFuzzyGender = rightFuzzyGender;
            return this;
        }

        public QueryBuilder rightFuzzyGender (String ... rightFuzzyGender){
            this.rightFuzzyGender = solveNullList(rightFuzzyGender);
            return this;
        }

        public QueryBuilder gender(String gender){
            setGender(gender);
            return this;
        }

        public QueryBuilder genderList(String ... gender){
            this.genderList = solveNullList(gender);
            return this;
        }

        public QueryBuilder genderList(List<String> gender){
            this.genderList = gender;
            return this;
        }

        public QueryBuilder fetchGender(){
            setFetchFields("fetchFields","gender");
            return this;
        }

        public QueryBuilder excludeGender(){
            setFetchFields("excludeFields","gender");
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

        public Patient build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> patNameList;

        public List<String> getPatNameList(){return this.patNameList;}


        private List<String> fuzzyPatName;

        public List<String> getFuzzyPatName(){return this.fuzzyPatName;}

        private List<String> rightFuzzyPatName;

        public List<String> getRightFuzzyPatName(){return this.rightFuzzyPatName;}
        private List<String> patNumberList;

        public List<String> getPatNumberList(){return this.patNumberList;}


        private List<String> fuzzyPatNumber;

        public List<String> getFuzzyPatNumber(){return this.fuzzyPatNumber;}

        private List<String> rightFuzzyPatNumber;

        public List<String> getRightFuzzyPatNumber(){return this.rightFuzzyPatNumber;}
        private List<String> birthDayList;

        public List<String> getBirthDayList(){return this.birthDayList;}


        private List<String> fuzzyBirthDay;

        public List<String> getFuzzyBirthDay(){return this.fuzzyBirthDay;}

        private List<String> rightFuzzyBirthDay;

        public List<String> getRightFuzzyBirthDay(){return this.rightFuzzyBirthDay;}
        private List<String> genderList;

        public List<String> getGenderList(){return this.genderList;}


        private List<String> fuzzyGender;

        public List<String> getFuzzyGender(){return this.fuzzyGender;}

        private List<String> rightFuzzyGender;

        public List<String> getRightFuzzyGender(){return this.rightFuzzyGender;}

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

        public ConditionBuilder fuzzyPatName (List<String> fuzzyPatName){
            this.fuzzyPatName = fuzzyPatName;
            return this;
        }

        public ConditionBuilder fuzzyPatName (String ... fuzzyPatName){
            this.fuzzyPatName = solveNullList(fuzzyPatName);
            return this;
        }

        public ConditionBuilder rightFuzzyPatName (List<String> rightFuzzyPatName){
            this.rightFuzzyPatName = rightFuzzyPatName;
            return this;
        }

        public ConditionBuilder rightFuzzyPatName (String ... rightFuzzyPatName){
            this.rightFuzzyPatName = solveNullList(rightFuzzyPatName);
            return this;
        }

        public ConditionBuilder patNameList(String ... patName){
            this.patNameList = solveNullList(patName);
            return this;
        }

        public ConditionBuilder patNameList(List<String> patName){
            this.patNameList = patName;
            return this;
        }

        public ConditionBuilder fuzzyPatNumber (List<String> fuzzyPatNumber){
            this.fuzzyPatNumber = fuzzyPatNumber;
            return this;
        }

        public ConditionBuilder fuzzyPatNumber (String ... fuzzyPatNumber){
            this.fuzzyPatNumber = solveNullList(fuzzyPatNumber);
            return this;
        }

        public ConditionBuilder rightFuzzyPatNumber (List<String> rightFuzzyPatNumber){
            this.rightFuzzyPatNumber = rightFuzzyPatNumber;
            return this;
        }

        public ConditionBuilder rightFuzzyPatNumber (String ... rightFuzzyPatNumber){
            this.rightFuzzyPatNumber = solveNullList(rightFuzzyPatNumber);
            return this;
        }

        public ConditionBuilder patNumberList(String ... patNumber){
            this.patNumberList = solveNullList(patNumber);
            return this;
        }

        public ConditionBuilder patNumberList(List<String> patNumber){
            this.patNumberList = patNumber;
            return this;
        }

        public ConditionBuilder fuzzyBirthDay (List<String> fuzzyBirthDay){
            this.fuzzyBirthDay = fuzzyBirthDay;
            return this;
        }

        public ConditionBuilder fuzzyBirthDay (String ... fuzzyBirthDay){
            this.fuzzyBirthDay = solveNullList(fuzzyBirthDay);
            return this;
        }

        public ConditionBuilder rightFuzzyBirthDay (List<String> rightFuzzyBirthDay){
            this.rightFuzzyBirthDay = rightFuzzyBirthDay;
            return this;
        }

        public ConditionBuilder rightFuzzyBirthDay (String ... rightFuzzyBirthDay){
            this.rightFuzzyBirthDay = solveNullList(rightFuzzyBirthDay);
            return this;
        }

        public ConditionBuilder birthDayList(String ... birthDay){
            this.birthDayList = solveNullList(birthDay);
            return this;
        }

        public ConditionBuilder birthDayList(List<String> birthDay){
            this.birthDayList = birthDay;
            return this;
        }

        public ConditionBuilder fuzzyGender (List<String> fuzzyGender){
            this.fuzzyGender = fuzzyGender;
            return this;
        }

        public ConditionBuilder fuzzyGender (String ... fuzzyGender){
            this.fuzzyGender = solveNullList(fuzzyGender);
            return this;
        }

        public ConditionBuilder rightFuzzyGender (List<String> rightFuzzyGender){
            this.rightFuzzyGender = rightFuzzyGender;
            return this;
        }

        public ConditionBuilder rightFuzzyGender (String ... rightFuzzyGender){
            this.rightFuzzyGender = solveNullList(rightFuzzyGender);
            return this;
        }

        public ConditionBuilder genderList(String ... gender){
            this.genderList = solveNullList(gender);
            return this;
        }

        public ConditionBuilder genderList(List<String> gender){
            this.genderList = gender;
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

        private Patient obj;

        public Builder(){
            this.obj = new Patient();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder patName(String patName){
            this.obj.setPatName(patName);
            return this;
        }
        public Builder patNumber(String patNumber){
            this.obj.setPatNumber(patNumber);
            return this;
        }
        public Builder birthDay(String birthDay){
            this.obj.setBirthDay(birthDay);
            return this;
        }
        public Builder gender(String gender){
            this.obj.setGender(gender);
            return this;
        }
        public Patient build(){return obj;}
    }

}
