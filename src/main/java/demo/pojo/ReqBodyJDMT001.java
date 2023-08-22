package demo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ReqBodyJDMT001 {
    private String enterpriseName;

    private String corpID;

    private List<BenefOwner>  BenefOwners;
}
