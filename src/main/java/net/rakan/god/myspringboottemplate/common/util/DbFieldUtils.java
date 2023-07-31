package net.rakan.god.myspringboottemplate.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据库字段转换
 *
 * @Author LiChangRui on 2022/4/13 10:58
 */
public class DbFieldUtils {

    private static final String dbField = "id\n" +
            "camera_id\n" +
            "unit_id\n" +
            "product_name\n" +
            "brand\n" +
            "device_type_code\n" +
            "model\n" +
            "facility_variety_code\n" +
            "design_unit_name\n" +
            "device_code\n" +
            "build_unit_name\n" +
            "design_use_year\n" +
            "type_test_organ_name\n" +
            "make_unit_name\n" +
            "supervision_inspect_organ_name\n" +
            "register_code\n" +
            "longitude\n" +
            "latitude\n" +
            "use_unit_address\n" +
            "use_unit_longitude\n" +
            "use_unit_latitude\n" +
            "use_unit_name\n" +
            "use_credit_code\n" +
            "postal_code\n" +
            "unit_code\n" +
            "facility_use_location\n" +
            "controls_use_date\n" +
            "unit_telephone\n" +
            "safety_admin\n" +
            "phone\n" +
            "title_unit_name\n" +
            "title_unit_credit_code\n" +
            "relation_phone\n" +
            "verify_organ_name\n" +
            "verify_type_code\n" +
            "verify_report_code\n" +
            "verify_date\n" +
            "next_verify_date\n" +
            "verify_conclusion_code\n" +
            "maintain_mode_code\n" +
            "emergency_rescue_unit_id\n" +
            "use_place_class_code\n" +
            "maintain_level_code\n" +
            "level_code\n" +
            "el_rated_deadweight\n" +
            "el_rated_speed\n" +
            "el_floor_stand_door\n" +
            "el_up_height\n" +
            "el_car_size\n" +
            "el_door_size\n" +
            "el_drive_mode\n" +
            "el_control_mode\n" +
            "el_drive_host_model\n" +
            "el_drive_host_model_code\n" +
            "el_stop_model\n" +
            "el_stop_model_code\n" +
            "el_move_protect_device_model\n" +
            "el_move_protect_device_model_code\n" +
            "el_control_cabinet_model\n" +
            "el_control_cabinet_model_code\n" +
            "el_safety_gear_model\n" +
            "el_safety_gear_model_code\n" +
            "el_buffer_model\n" +
            "el_buffer_model_code\n" +
            "el_safety_circuit_model\n" +
            "el_safety_circuit_model_code\n" +
            "el_suspen_device_param\n" +
            "el_suspen_device_model\n" +
            "el_suspen_device_name\n" +
            "el_programmable_sys_model\n" +
            "el_programmable_sys_model_code\n" +
            "el_car_door_model\n" +
            "el_door_model\n" +
            "el_car_door_lock_model\n" +
            "el_door_lock_model\n" +
            "es_nominal_velocity\n" +
            "es_nominal_breadth\n" +
            "es_use_length\n" +
            "es_up_height\n" +
            "es_angle_inclination\n" +
            "es_transport_capacity\n" +
            "es_drive_host_model\n" +
            "es_drive_host_model_code\n" +
            "es_control_cabinet_model\n" +
            "es_control_cabinet_model_code\n" +
            "es_programmable_sys_model\n" +
            "es_programmable_sys_model_code\n" +
            "es_step\n" +
            "es_step_code\n" +
            "es_comb_support_plate_model\n" +
            "es_wainscot_material_model\n" +
            "es_floor_panel_model\n" +
            "create_by\n" +
            "create_time\n" +
            "update_by\n" +
            "update_time\n" +
            "del_flag\n";

    public static void main(String[] args) {
        toJavaString("ele");
//        toJsonObject();
//        toHump();
    }

    public static void toJavaString(String asName) {

        String[] dbFields = dbField.split("\n");

        for (String dbFieldItem : dbFields) {
            if (StringUtils.isNotBlank(dbFieldItem)) {
                System.out.print(asName + ".");
            }
            System.out.println(dbFieldItem + " as " + toCamelCase(dbFieldItem) + ",");
        }
    }

    public static void toJsonObject(){
        String[] dbFields = dbField.split("\n");

        for (String dbFieldItem : dbFields) {
            System.out.println("\""+toCamelCase(dbFieldItem)+"\":"+"\"\"");
        }
    }

    public static void toHump(){
        String[] dbFields = dbField.split("\n");
        for (String dbFieldItem : dbFields) {
            System.out.print(toCamelCase(dbFieldItem)+": "+"||");
        }
    }

    /**
     * 驼峰式命名法
     *
     * @Author LiChangRui on 2022/4/13 11:13
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('_' == c) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
