package com.bikeming.basemvp.demo;

/**
 * @ClassName: com.bikeming.basemvp.demo
 * @Description:
 * @author: fjm
 * @date: 2019/8/26 17:32
 * @Version:1.0
 */
public class LoginResponse {
    /**
     * map : {"ui":"5c01efa21563284cc7ef3aba","sex":"0","snm":"合肥北城中学","chatid":"5c01efa21563284cc7ef3aba","nnm":"北城中学班牌管理员","ur":"10","un":"北城中学班牌管理员","si":"59a6160071f0564dbc41f4a6","up":"","avt":"head-default-head.jpg","exp":"5","slogo":"http://doc.k6kt.com/5c6a0eedeca6ea045dc41798.png","urp":"","coupon":"0","k6kt":"1"}
     * id : 5c01efa21563284cc7ef3aba
     * userRole : 10
     * chatid : 5c01efa21563284cc7ef3aba
     * realName : 北城中学班牌管理员
     * maxAvatar : http://doc.k6kt.com/head-default-head.jpg
     * schoolId : 59a6160071f0564dbc41f4a6
     * userName : 北城中学班牌管理员
     * avatar : head-default-head.jpg
     * schoolName : 合肥北城中学
     * sex : 0
     * schoolLogo : http://doc.k6kt.com/5c6a0eedeca6ea045dc41798.png
     * salaryAdmin : 0
     * experience : 5
     * equipmentRole : 0
     * k6kt : 1
     * userPermission :
     * userRemovePermission :
     * schoolNavs : navs
     * coupon : 0
     * attendAdmin : 0
     * attendTeacher : 0
     * andiAdmin : 0
     * developAdmin : 0
     * staffDormAdmin : 0
     * overallAdmin : 0
     * challengeEvalRole : 0
     * staffEvalRole : 0
     * expandAdmin : 0
     * expandXunTang : 0
     * patrolAdmin : 0
     * patrolMember : 0
     * leaderAdmin : 0
     * educationLogo :
     * userRoleDes : 校长
     * cloudUrl :
     * minAvatar : http://doc.k6kt.com/head-default-head.jpg
     * midAvatar : http://doc.k6kt.com/head-default-head.jpg
     * sso :
     * clsResAdmin : 0
     * stuEvaluateTeacherRoleAdmin : 0
     * empty : false
     */

    private MapBean map;
    private String id;
    private int userRole;
    private String chatid;
    private String realName;
    private String maxAvatar;
    private String schoolId;
    private String userName;
    private String avatar;
    private String schoolName;
    private int sex;
    private String schoolLogo;
    private int salaryAdmin;
    private int experience;
    private int equipmentRole;
    private int k6kt;
    private String userPermission;
    private String userRemovePermission;
    private String schoolNavs;
    private int coupon;
    private int attendAdmin;
    private int attendTeacher;
    private int andiAdmin;
    private int developAdmin;
    private int staffDormAdmin;
    private int overallAdmin;
    private int challengeEvalRole;
    private int staffEvalRole;
    private int expandAdmin;
    private int expandXunTang;
    private int patrolAdmin;
    private int patrolMember;
    private int leaderAdmin;
    private String educationLogo;
    private String userRoleDes;
    private String cloudUrl;
    private String minAvatar;
    private String midAvatar;
    private String sso;
    private int clsResAdmin;
    private int stuEvaluateTeacherRoleAdmin;
    private boolean empty;

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMaxAvatar() {
        return maxAvatar;
    }

    public void setMaxAvatar(String maxAvatar) {
        this.maxAvatar = maxAvatar;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public int getSalaryAdmin() {
        return salaryAdmin;
    }

    public void setSalaryAdmin(int salaryAdmin) {
        this.salaryAdmin = salaryAdmin;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEquipmentRole() {
        return equipmentRole;
    }

    public void setEquipmentRole(int equipmentRole) {
        this.equipmentRole = equipmentRole;
    }

    public int getK6kt() {
        return k6kt;
    }

    public void setK6kt(int k6kt) {
        this.k6kt = k6kt;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserRemovePermission() {
        return userRemovePermission;
    }

    public void setUserRemovePermission(String userRemovePermission) {
        this.userRemovePermission = userRemovePermission;
    }

    public String getSchoolNavs() {
        return schoolNavs;
    }

    public void setSchoolNavs(String schoolNavs) {
        this.schoolNavs = schoolNavs;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getAttendAdmin() {
        return attendAdmin;
    }

    public void setAttendAdmin(int attendAdmin) {
        this.attendAdmin = attendAdmin;
    }

    public int getAttendTeacher() {
        return attendTeacher;
    }

    public void setAttendTeacher(int attendTeacher) {
        this.attendTeacher = attendTeacher;
    }

    public int getAndiAdmin() {
        return andiAdmin;
    }

    public void setAndiAdmin(int andiAdmin) {
        this.andiAdmin = andiAdmin;
    }

    public int getDevelopAdmin() {
        return developAdmin;
    }

    public void setDevelopAdmin(int developAdmin) {
        this.developAdmin = developAdmin;
    }

    public int getStaffDormAdmin() {
        return staffDormAdmin;
    }

    public void setStaffDormAdmin(int staffDormAdmin) {
        this.staffDormAdmin = staffDormAdmin;
    }

    public int getOverallAdmin() {
        return overallAdmin;
    }

    public void setOverallAdmin(int overallAdmin) {
        this.overallAdmin = overallAdmin;
    }

    public int getChallengeEvalRole() {
        return challengeEvalRole;
    }

    public void setChallengeEvalRole(int challengeEvalRole) {
        this.challengeEvalRole = challengeEvalRole;
    }

    public int getStaffEvalRole() {
        return staffEvalRole;
    }

    public void setStaffEvalRole(int staffEvalRole) {
        this.staffEvalRole = staffEvalRole;
    }

    public int getExpandAdmin() {
        return expandAdmin;
    }

    public void setExpandAdmin(int expandAdmin) {
        this.expandAdmin = expandAdmin;
    }

    public int getExpandXunTang() {
        return expandXunTang;
    }

    public void setExpandXunTang(int expandXunTang) {
        this.expandXunTang = expandXunTang;
    }

    public int getPatrolAdmin() {
        return patrolAdmin;
    }

    public void setPatrolAdmin(int patrolAdmin) {
        this.patrolAdmin = patrolAdmin;
    }

    public int getPatrolMember() {
        return patrolMember;
    }

    public void setPatrolMember(int patrolMember) {
        this.patrolMember = patrolMember;
    }

    public int getLeaderAdmin() {
        return leaderAdmin;
    }

    public void setLeaderAdmin(int leaderAdmin) {
        this.leaderAdmin = leaderAdmin;
    }

    public String getEducationLogo() {
        return educationLogo;
    }

    public void setEducationLogo(String educationLogo) {
        this.educationLogo = educationLogo;
    }

    public String getUserRoleDes() {
        return userRoleDes;
    }

    public void setUserRoleDes(String userRoleDes) {
        this.userRoleDes = userRoleDes;
    }

    public String getCloudUrl() {
        return cloudUrl;
    }

    public void setCloudUrl(String cloudUrl) {
        this.cloudUrl = cloudUrl;
    }

    public String getMinAvatar() {
        return minAvatar;
    }

    public void setMinAvatar(String minAvatar) {
        this.minAvatar = minAvatar;
    }

    public String getMidAvatar() {
        return midAvatar;
    }

    public void setMidAvatar(String midAvatar) {
        this.midAvatar = midAvatar;
    }

    public String getSso() {
        return sso;
    }

    public void setSso(String sso) {
        this.sso = sso;
    }

    public int getClsResAdmin() {
        return clsResAdmin;
    }

    public void setClsResAdmin(int clsResAdmin) {
        this.clsResAdmin = clsResAdmin;
    }

    public int getStuEvaluateTeacherRoleAdmin() {
        return stuEvaluateTeacherRoleAdmin;
    }

    public void setStuEvaluateTeacherRoleAdmin(int stuEvaluateTeacherRoleAdmin) {
        this.stuEvaluateTeacherRoleAdmin = stuEvaluateTeacherRoleAdmin;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public static class MapBean {
        /**
         * ui : 5c01efa21563284cc7ef3aba
         * sex : 0
         * snm : 合肥北城中学
         * chatid : 5c01efa21563284cc7ef3aba
         * nnm : 北城中学班牌管理员
         * ur : 10
         * un : 北城中学班牌管理员
         * si : 59a6160071f0564dbc41f4a6
         * up :
         * avt : head-default-head.jpg
         * exp : 5
         * slogo : http://doc.k6kt.com/5c6a0eedeca6ea045dc41798.png
         * urp :
         * coupon : 0
         * k6kt : 1
         */

        private String ui;
        private String sex;
        private String snm;
        private String chatid;
        private String nnm;
        private String ur;
        private String un;
        private String si;
        private String up;
        private String avt;
        private String exp;
        private String slogo;
        private String urp;
        private String coupon;
        private String k6kt;

        public String getUi() {
            return ui;
        }

        public void setUi(String ui) {
            this.ui = ui;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSnm() {
            return snm;
        }

        public void setSnm(String snm) {
            this.snm = snm;
        }

        public String getChatid() {
            return chatid;
        }

        public void setChatid(String chatid) {
            this.chatid = chatid;
        }

        public String getNnm() {
            return nnm;
        }

        public void setNnm(String nnm) {
            this.nnm = nnm;
        }

        public String getUr() {
            return ur;
        }

        public void setUr(String ur) {
            this.ur = ur;
        }

        public String getUn() {
            return un;
        }

        public void setUn(String un) {
            this.un = un;
        }

        public String getSi() {
            return si;
        }

        public void setSi(String si) {
            this.si = si;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getAvt() {
            return avt;
        }

        public void setAvt(String avt) {
            this.avt = avt;
        }

        public String getExp() {
            return exp;
        }

        public void setExp(String exp) {
            this.exp = exp;
        }

        public String getSlogo() {
            return slogo;
        }

        public void setSlogo(String slogo) {
            this.slogo = slogo;
        }

        public String getUrp() {
            return urp;
        }

        public void setUrp(String urp) {
            this.urp = urp;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public String getK6kt() {
            return k6kt;
        }

        public void setK6kt(String k6kt) {
            this.k6kt = k6kt;
        }
    }
}
